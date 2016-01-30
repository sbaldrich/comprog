#include<bits/stdc++.h>

using namespace std;

const bool debug = true;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

typedef pair<int,int> pii;

ostream& operator<<(ostream &o, pii p){
	return o << "[ "<< p.first << " " << p.second << " ]";
}

ostream& operator<<(ostream &o, vector<pii> p){
	o << "{";
	for(int i=0;i<p.size();i++)
		o << " " << p[i];
	return o << " }";
}

char b[8][8];

int dr[] = {-2,-2,2,2};
int dc[] = {-2,2,2,-2};

set< pair<pii, pii> > visit, visitb;

bool ok(pii p){
	bool x = p.first  >= 0 && p.first <= 7 && p.second >= 0 && p.second <= 7;
	//cout << "ok(" << p <<") => " << boolalpha << x << endl;
	return x;
}

void f(pii k1, pii k2, int m = 0){
	//cout << "f(" << k1 << ", " << k2  << " " << m << " )" << endl;
	if(m)
		visitb.insert(make_pair(k1,k2));
	else
		visit.insert(make_pair(k1, k2));
	if(k1.first == k2.first && k1.second == k2.second && b[k1.first][k1.second] != '#'){
		if(m == 2)
			throw int();
		else{
			visitb.clear();
			f(k1,k2,m+1);
		}
	}
	
	pii p, q;
	
	rep(i,0,3){
		p = make_pair(k1.first  + dr[i], k1.second + dc[i]);
		if(!ok(p))
			continue;
		rep(j,0,3){
			q = make_pair(k2.first  + dr[j], k2.second + dc[j]);
			if(ok(q)){
				if(!m && visit.find(make_pair(p,q)) == visit.end())
					f(p,q);
				if(m && visitb.find(make_pair(p,q)) == visitb.end())
					f(p,q,m);
			}
		}
	}
}


int main(){
	if(debug){
		freopen("aa.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}	
	int t;
	vector<pii> v1,v2,v3;
	pii k1,k2;
	cin >> t;
	while(t--){
		bool flag = false;
		rep(i,0,7)
			rep(j,0,7){
				cin >> b[i][j];
				if(b[i][j] == 'K'){
					if(flag)
						k2 = make_pair(i,j);
					else{
							k1 = make_pair(i,j);
							flag = true;
						}
					b[i][j] = '.';
				}
			}
		visit.clear();visitb.clear();
		try{
			f(k1,k2);
			cout << "NO";
		}
		catch(...){
			cout << "YES";
		}

		cout << endl;
	}
	
	return 0;
}

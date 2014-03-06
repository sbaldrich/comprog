#include<bits/stdc++.h>

using namespace std;

const bool debug = true;

#define D(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define DD(x,y) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << " ]" << endl;
#define DDD(x,y,z) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << ", " << #z << " => " << z << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

template<class T>
inline ostream& operator<<(ostream& out, vector<T> v){
	out << "[";
	int i,n = v.size();
	for(i=0; i<n; i++)
		out << " " << v[i];
	return out << " ]";
}

template<class S, class T>
inline ostream& operator<<(ostream& out, pair<S,T> pp){
	return out << "{ " << pp.first << ", " << pp.second << " }";
}

int main(){
	if(debug)
		freopen("aa.in", "r", stdin);
	int n,m; cin >> n >> m;
	vector<int> v(n*m);
	map<int,int> m;
	for(int i=0,x;i<n*m;i++){
		cin >> x;
		m[ x == 11 ? 2 : x] ++;
	}
	vector< vector<int> > g(n , vector<int>(m));
	D(v)	
	for(int i=0,q=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(m[2]){
				g[i][j] = 2;
				m[2]--;
			}
			else{
				if(i){
					if(g[i-1][j] == 2){
						if(m[0]){
							g[i][j] = 0;
							m[0]--;
						}
						else if(m[1]){
							
						}
					}
					else if(abs(g[i-1][j])) 
				}
			}
		}
	}
	D("")
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			int &r = g[i][j];
			if(r == 2)
				cout << 11;
			else if(r == 1)
				cout << 10;
			else if(r == -1)
				cout << "01";
			else cout << "00";
			if(j<m-1)
				cout << " ";
		}
		cout << endl;
	}
	
	return 0;
}

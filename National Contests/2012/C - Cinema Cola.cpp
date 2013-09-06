#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<utility>
#include<algorithm>
using namespace std;

const int NN = 100;
int cinema[NN][NN];

void map(const string &s, int &r, int &c){
	r = s[0] - 'A';
	c = s[1] - '0';
	if(s.size() > 2)
		c*=10,c+=s[2] - '0';
	r++;
}

void out(int *a, int n){
	for(int i=0;i<=n;i++)
		cout << a[i] << " ";
	cout << endl;
}

typedef pair<int,int> pii;

int main(){
	freopen("C.in" , "r", stdin);
	for(int m,n,p,f;cin>>m>>n && m && n;){
		memset(cinema, 0, sizeof(int) * NN * NN);
		string s;
		int r,c;
		char d;
		cin>>p;
		for(int i=0;i<p;i++){
			cin>>s>>d;
			map(s,r,c);
			cinema[r][c] = d == '-' ? -1:1;
		}
//		for(int i=0;i<=m;i++)
//			out(cinema[i],n);
		cin >> p;
		vector< pii > v(p);
		for(int i=0;i<p;i++){
			cin>>s;
			//cout << s << endl ;
			map(s,r,c);
			v[i] = make_pair(r,c);
		}
		sort(v.begin(),v.end());
		bool possible = true;
		
		for(int i=0;i<p;i++){
			pii act = v[i];
			r = act.first, c = act.second;
			if(cinema[r][c-1] != 1)
				cinema[r][c] = -1;
			else if (cinema[r][c+1] != -1)
				cinema[r][c] = 1;
			else possible = false;
			//cout << ">>>"<< endl;

		//	for(int i=0;i<=m;i++)
		//		out(cinema[i],n);
		}
		cout << (possible?"YES":"NO") << endl;
	}	
	return 0;
}

#include<iostream>
#include<cstring>
#include<set>
#include<vector>

using namespace std;

#define vvi vector< vector<int> >
#define contains(c,x) (c.find(x) != c.end())


int dr[] = {0,-1,0,1};
int dc[] = {-1,0,1,0};



set< vvi > visit;

ostream& operator<<(ostream& o, const vvi &m){
	for(int i=0;i<m.size();i++){
		for(int j=0;j<m[i].size();j++)
			o << m[i][j];
		cout << endl;
	}
	return o;
}

void f(vvi &m){
	vvi t(m);
	for(int i=1;i<4;i++)
		for(int j=1;j<4;j++){
			int accum = 0;
			for(int k=0;k<4;k++)
				accum += t[i + dr[k]][j + dc[k]];
			m[i][j] = accum % 2;
		}
}

int main(){

	//freopen("p4.in",  "r", stdin);
	int tc; 
	cin>>tc;
	while(tc--){
		visit.clear();
		vvi m(5, vector<int>(5, 0));
		char c;
		for(int i=1;i<=3;i++)
			for(int i2=1;i2<=3;i2++){
				cin>>c;
				m[i][i2] = c - '0';	
			}
		int ans = 0;
		visit.insert(m);
		while(1){
			f(m);
			if(contains(visit,m))
				break;
			visit.insert(m);
			ans++;
		}		
		cout << (ans?ans-1:-1) << endl;
	}
	return 0;
}

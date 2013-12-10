#include<iostream>
#include<cstdio>
#include<vector>

using namespace std;

#define max(a,b) (a) > (b) ? (a) : (b)

int main(){
	freopen("aa.in", "r", stdin);
	int n,m,c,x,q,qq,cc = 1;
	while(cin >> n >> m >> c && n && m && c){
		vector<bool> state(n,false);
		vector<int> cons(n,0);
		for(int i=0;i<n;i++)
			cin >> cons[i];
		q = qq = 0;
		for(int i=0;i<m;i++){
			cin >> x, x--;
			if(state[x])
				q-=cons[x];
			else
				q += cons[x];
			state[x] = !state[x];
			qq = max(qq,q);
		}
		cout << "Sequence " << cc++ << endl;
		if( qq > c )
			cout << "Fuse was blown." << endl;
		else
			cout << "Fuse was not blown." << endl << "Maximal power consumption was " << qq << " amperes." << endl;
		cout << endl;
	}
	return 0;
}

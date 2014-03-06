#include<bits/stdc++.h>

using namespace std;

const bool debug = true;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int dr[] = {1,2,1,1};
int dc[] = {0,0,-1,1};

int main(){
	if(debug)
		freopen("aa.in", "r", stdin);
	int n;
	cin >> n;
	char b[n+2][n+2];
	rep(i,0,n+1)
		rep(j,0,n+1)
			b[i][j] = '.';
	rep(i,1,n)
		rep(j,1,n)
			cin >> b[i][j];
	bool flag = false;
	
	rep(i,1,n){
		rep(j,1,n)
			if(b[i][j] == '#'){
				for(int k=0;k<4;k++){
					char &ref = b[i+dr[k]][j+dc[k]]; 
				if( ref != '#')
					flag = true;
				else ref = '.';
			}	
		}
	}
		
	if(flag)
		cout << "NO";
	else cout << "YES";
	cout << endl;
	return 0;
}

#include<algorithm>
#include<iostream>
#include<sstream>
#include<iomanip>
#include<cstring>
#include<set>
#include<queue>
#include<utility>
#include<map>
#include<string>
#include<cstdio>
#include<cmath>
#include<vector>
#include<bitset>
#include<stack>

using namespace std;

const bool debug = true;
#define TRACE(x) cout << "[ " << #x << " => " << x << "]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int gcd ( int a, int b )
{
  if ( a==0 ) return b;
  return gcd ( b%a, a );
}

int main(){
	if(debug){
		freopen("bb.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}
	int n, k, kk;
	cin >> n >> k;
	if( k == n )
		cout << -1 << endl;
	else{
		vector<int> v(n+1, 0);
		for(int i=1;i<=n;i++)
			v[i] = i;
		bool ok = true;
		kk = n - 1 - k;
		int idx=2;
		bool flag = false;
		if( kk & 1){
			v[1] = 2;
			v[2] = 1;
			kk--;
			flag = true;
		}
		for(int i=2+flag;i<n && kk;i+=2,kk-=2){
			int t = v[i+1];
			v[i+1] = v[i];
			v[i] = t;
		}
		
		if(!kk)
			for(int i=1;i<=n;i++)
				cout << v[i] << (i<n?" ":"\n");
		else cout<< -1 << endl;
	}
	return 0;
}

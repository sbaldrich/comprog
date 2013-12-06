#include<bits/stdc++.h>

using namespace std;

const bool debug = true;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int main(){
	if(debug){
		freopen("bb.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}
	int n;
	cin >> n;
	vector<int> v(n);
	int ans=2,x=2;
	for(int i=0;i<n;i++)
		cin >> v[i];
	if( n <= 2){cout << n << endl; return 0;}
	for(int i=2;i<n;i++){
		if(v[i] == v[i-1] + v[i-2])
			x++;
		else{
			ans = max(x,ans);
			x = 2;
		}
	}
	ans = max(ans,x);
	cout << ans << endl;
		
	return 0;
}

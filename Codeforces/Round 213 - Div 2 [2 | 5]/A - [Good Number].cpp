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
	if(debug)
		freopen("aa.in", "r", stdin);
	int n,k,ans = 0;
	string s = "0123456789", x;
	cin >> n >> k;
	for(int i=0; i < n; i++){
		cin >> x;
		set<char> ss(all(x));
		string t = string(all(ss)); 
		if(s.substr(0,k+1) == t.substr(0,k+1))
			ans++;
	}
	cout << ans << endl;
	return 0;
}

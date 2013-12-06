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
	int n,d,m;
	cin >> n >> d;
	vector<int> v(n);
	for(int i=0;i<n;i++)
		cin >> v[i];
	sort(all(v));
	cin >> m;
	int ans = 0;
	for(int i=0;i<m;i++)
		ans+=v[i];
	ans -= max(0,m - n)*d;
	cout << ans << endl;
	return 0;
}

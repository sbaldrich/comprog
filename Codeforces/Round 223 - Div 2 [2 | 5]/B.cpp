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
		freopen("bb.in", "r", stdin);
	int n,m = 0,q=0;
	cin >> n;
	vector<int> v(5001, 0), ans;
	for(int i=0,x; i<n; i++){
		cin >> x;
		m = max(m,x);
		v[x]++;
	}
	for(int i=0;i<=m; i++){
		if(v[i]){
			ans.push_back(i);
			v[i]--;
		}
	}
	for(int i=m-1;i>=0;i--){
		if(v[i])
			ans.push_back(i);
	}
	cout << ans.size() << endl;
	for(int i=0;i<ans.size();i++)
		cout << ans[i] << (i < n-1?" ": "\n");
	return 0;
}

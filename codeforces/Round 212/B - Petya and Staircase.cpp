#include<bits/stdc++.h>

using namespace std;

const bool debug = false;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int main(){
	if(debug){
		freopen("aa.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}
	int n , m;
	cin >> n >> m;
	vector<int> v(m);
	for(int i=0;i<m;i++)
		cin >> v[i];
	sort(all(v));
	bool ok = true;
	rep(i,0,m-1)
		cout << v[i] << " ";
	cout << endl;
	for(int i=0;i<m-3 && ok;i++)
		ok &= (v[i] + 1) != v[i+1] || (v[i+1] + 1) != v[i+2];
	cout << (ok && v[0] != 1 && v[m-1] != n ? "YES" : "NO") << endl;
	return 0;
}

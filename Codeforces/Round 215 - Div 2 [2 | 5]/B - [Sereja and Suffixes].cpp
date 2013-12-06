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
	int n, m;
	cin >> n >> m;
	vector<int> v(n), a(n, 0);
	set<int> s;
	rep(i,0,n-1)
		cin >> v[i];
	for(int i=n-1;i>=0;i--){
		if(i==n-1){
			s.insert(v[n-1]);
			a[i] = 1;
		}
		else{
			a[i] = a[i+1];
			if(s.find(v[i]) == s.end())
				s.insert(v[i]), a[i]++;
		}
	}
	for(int i=0,x; i < m; i++){
		cin >> x;
		cout << a[x-1] << endl;
	}	
	
	return 0;
}

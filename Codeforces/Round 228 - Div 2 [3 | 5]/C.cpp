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
	int n; cin >> n;
	vector<int> v(n), l(n,-1), q(n,-1);
	for(int i=0;i<n;i++)
		cin >> v[i];
	sort(all(v));
	int ans = 0,b;

	for(int i=0;i<n;i++){
		for(b=0; l[b]>-1; b++){
			if(v[i] >= q[b]){
				q[b]++;
				l[b] = v[i]+1;
				break;
			}
		}

		if(l[b]	== -1){
			q[ans] = 1;
			l[ans] = v[i]+1;
			ans++;
		}
	}

	cout << ans << endl;
	return 0;
}

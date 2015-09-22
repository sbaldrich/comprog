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
	int n, l = 0, s = 0, d = 0, m;
	cin >> n;
	vector<int> v(n);
	for(int i=0;i<n;i++)
		cin >> v[i];
	--n;
	bool ser = true;
	while(l <= n){
		if(v[l] > v[n]){
			m = v[l++];
		}
		else m = v[n--];
		if(ser)
			s += m;
		else 
			d += m;
		ser = !ser;
	}
	cout << s << " "<<d << endl;
	return 0;
}

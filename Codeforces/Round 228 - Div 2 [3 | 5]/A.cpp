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
	if(debug)
		freopen("aa.in", "r", stdin);
	int n,l;
	cin >> n;
	vector<int> v(n);
	rep(i,0,n-1)
		cin >> v[i];
	//for(int i=0;i<n;i++)
	//	cout << v[i] << " ";
//	cout << endl;
	while(1){
		sort(all(v));
		l = n-2;
		while(v[l] >= v[n-1] && l >= 0)
			l--;
		if(l<0)
			break;
		v[n-1] -= v[l];
	}
	int init = 0;
	cout << accumulate(all(v),init) << endl;

	return 0;
}

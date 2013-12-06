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
	int n, k, l, r, sa, sk, nx = 0, ssa = 0, ssk = 0;
	cin >> n >> k >> l >> r >> sa >> sk;
	ssa = n*l , ssk = k*l;
	if(sa == n*r){
		for(int i=0;i<n;i++)
			cout << r << (i<n-1?" ":"\n");
		return 0;
	}
	vector<int> v(n,l);
	int mm = sk % k;
	fill_n(v.begin(), k, (sk - mm)/k);
	while(mm){
		if(v[nx] + mm > r){
			mm -= r - v[nx];
			TRACE(mm);
			TRACE(v[nx]);
			v[nx] = r;
			TRACE(v[nx]);
			nx++;
		}
		else{
			v[nx] += mm;
			mm = 0;
		}
	}
	r = v[k-1];
	if(n!=k){
		mm = (sa - sk) % (n - k);
		nx = k;
		fill_n(v.begin() + k, n-k, (sa - sk - mm)/(n-k));
		while(mm){
			if(v[nx] + mm > r){
				mm -= r - v[nx];
				v[nx] = r;
				nx++;
			}
			else{
				v[nx] += mm;
				mm = 0;
			}
		}
	}	
	for(int i=0;i<n;i++)
		cout << v[i] << (i<n-1?" ":"\n");
	return 0;
}

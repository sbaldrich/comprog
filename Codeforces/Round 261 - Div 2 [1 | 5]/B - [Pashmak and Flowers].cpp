#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(){
    int n; cin >> n;
    vector<ll> v(n);
	ll low = 1LL << 40 , high = 0LL;
	for( int i = 0 ; i < n; i++ ){
		cin >> v[i];
		low = min( v[i], low );
		high = max( v[i], high );
	}
	ll cl = count( v.begin(), v.end(), low );
	ll ch = count( v.begin(), v.end(), high );
	if( low == high )
		cout << 0 << " " << cl * (cl-1) / 2;
	else
		cout << high - low << " " << cl * ch;
	return 0;
}

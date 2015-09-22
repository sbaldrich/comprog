#include<bits/stdc++.h>
#define D(x,y) cout << "[ " << #x << ": " << x << ", " << #y <<": " << y << " ]" << endl;
using namespace std;

int main(){
	int n,m,k,t; cin >> n >> m >> k;
	if( k == n * m ){
		cout << 1 << endl;
		return 0;
	}
	if( n == 1 ){
		cout << m - k << endl;
		return 0;
	}
	if( m == 1 ){
		cout << n - k << endl;
		return 0;
	}
	int ans = n * m;
	if( n < m )
		swap( n, m );
	t = k / n;
	k -= t * n;
	D(k,t)
	m -= t;
	--k;
	ans = ( n-k ) * m;
	cout << ans << endl;
	return 0;
}

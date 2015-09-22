#include<bits/stdc++.h>
#define d(x) cout << #x << ": " << x << endl
using namespace std;

int main(){
	int n,m,k,f;
	cin >> n >> m >> k;
	vector<int> v(m);
	for( int i = 0; i < m; cin >> v[i++]);
	cin >> f;
	int ans = 0;
	for( int i = 0, d; i < m; i++ ){
		d = 0;
		for( int j = 0; j < n; j++ )
			if( ( ( 1 << j ) & f ) != ( ( 1 << j ) & v[i] ) )
				d++;
		if( d <= k )
			ans++;
	}
	cout << ans << endl;
	return 0;
}

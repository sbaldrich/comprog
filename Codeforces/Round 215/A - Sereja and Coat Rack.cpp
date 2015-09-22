#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,d,m;
	cin >> n >> d;
	vector<int> v( n );
	for( int i = 0;i < n; i++ )
		cin >> v[i];
	sort( v.begin(), v.end() );
	cin >> m;
	int ans = 0;
	for( int i = 0; i < min( n, m ); i++ )
		ans += v[i];
	ans -= max( 0, m - n ) * d;
	cout << ans << endl;
	return 0;
}

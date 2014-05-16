#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,k; cin >> n >> k;
	vector<int> v( n );
	for( int i = 0; i < n; i++ )
		cin >> v[i];
	sort( v.begin(), v.end() );
	int ans = 0;
	k = 5-k;
	for( int i = 0; i <= n - 3; i+=3 )
		ans +=( v[i] <= k && v[i+1] <= k && v[i+2] <= k );
	cout << ans << endl;

	return 0;	
}

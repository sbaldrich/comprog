#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,m; cin >> n >> m;
	vector<int> v( n );
	for( int i=0; i<n; i++ )
		cin >> v[i];
	int ans = 1, b = m - v[0];
	for( int i=1; i<n; i++ ){
		if( v[i] > b ){
			ans++;
			b = m - v[i];
		}
		else b -= v[i];
	}
	cout << ans << endl;
	return 0;
}

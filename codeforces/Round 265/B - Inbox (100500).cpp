#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n; cin >> n;
	int ans = 0;
	bool list = true;
	for( int i = 0,x; i < n; i++ ){
		cin >> x;
		if( x ){
			if( list )
				list = false;
			ans++;
		}
		else{
			if( !list ){
				list = true;
				ans++;
			}
		}
	}
	if( ans && list ) ans--;
	cout << ans << endl;
	return 0;
}

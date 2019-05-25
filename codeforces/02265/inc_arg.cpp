#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n; cin >> n;
	string s; cin >> s;
	int ans = 0;
	for( int i = 0; i < n; i++ ){
		ans++;
		if( s[i] == '0' )
			break;
	}
	cout << ans << endl;
	return 0;
}

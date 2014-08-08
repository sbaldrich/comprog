#include<bits/stdc++.h>

using namespace std;

bool on[11];

int main(){
	ios::sync_with_stdio(0);
	int n; cin >> n;
	string s[110];
	for( int i = 0; i < n; i++ )
		cin >> s[i];
	
	map<char,int> m;
	m['R'] = 6;
	m['G'] = 7;
	m['B'] = 8;
	m['Y'] = 9;
	m['W'] = 10;
	
	int ans = 25;
	for( int mask = 0, cur = 0; mask < (1 << 10); mask++ ){
		for( int i = 0; i <= 10; i++ )
			on[i+1] = ( mask >> i) & 1 ? 1 : 0;
		cur = __builtin_popcount(mask); 
		if( cur >= ans )
			continue;
		bool ok = true;
		bool deb = false;
		for( int i = 0; i < n; i++ ){
			for( int j = i+1; j < n; j++ )
				if( s[i] != s[j] ){
					if( s[i][0] == s[j][0] )
						ok &= ( on[s[i][1] -'0'] || on[s[j][1] - '0' ] ) ;
					else if( s[i][1] == s[j][1] )
						ok &= ( on[ m[ s[i][0] ] ] || on[ m[ s[j][0] ] ] );
					else ok &= ( on[ m[ s[i][0] ] ] || on[ m[ s[j][0] ] ] || on[ s[i][1] - '0' ] || on[ s[j][1] - '0' ] ) ;
				}
		}
		if( ok )
			ans = cur;
	}
	cout << ans << endl;
	return 0;
}

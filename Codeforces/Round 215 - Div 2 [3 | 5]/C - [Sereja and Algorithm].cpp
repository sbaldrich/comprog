#include<bits/stdc++.h>

using namespace std;

int c[ 3 ][ (int)1e5 + 10 ];

int main(){
	string s;
	cin >> s;
	for( int i = 1; i <= (int) s.size(); i++ ){
		for( int j = 0; j < 3; j++ )
			c[ j ][ i ] = c[ j ][ i - 1 ];
		c[ s[i-1] - 'x' ][ i ]++;
	}
	int m, l, r;
	cin >> m;
	while( m-- ){
		cin >> l >> r;
		if( r - l < 2 ) 
			cout << "YES" << endl;
		else{
			int cc[3] = {0}, x = 1e5, y = 0;
			for( int i = 0; i < 3; i++ ){
				cc[ i ] = c[ i ][ r ] - c[ i ][ l - 1];
				x = min( x, cc[i] );
				y = max( y, cc[i] );
			}
			bool ok = y - x <= 1;
			cout << ( ok ? "YES" : "NO" ) << endl;
		}
	}
}

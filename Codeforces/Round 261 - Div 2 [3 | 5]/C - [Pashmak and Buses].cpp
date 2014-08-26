#include<bits/stdc++.h>

using namespace std;

const int MM = 1000 + 10;

int buses[ MM ][ MM ];

typedef long long ll;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	ll n, d, k; cin >> n >> k >> d;
	bool possible = false;
	ll tt = k;
	for( int i = 1; i < d; i++ ){
		tt *= k;
		if( tt >= n ){
			possible = true;
			break;
		}
	}
	possible |= tt >= n;
	if( !possible )
		cout << -1 << endl;
	else{
		for( int i = 1 ; i < n; i++ ){
			for( int j = 0; j < d; j++ )
				buses[i][j] = buses[i-1][j];
			for( int j = d-1; j >= 0; j-- ){
				buses[i][j] = ( buses[i-1][j] + 1 ) % k;
				if( buses[i][j] )
					break;
			}			
		}
		for( int i = 0; i < d; i++ ){
			for( int j = 0; j < n; j++ )
				cout << ( j ? " " : "" ) << ++buses[j][i];
			cout << endl;
		}
	}
	return 0;
}

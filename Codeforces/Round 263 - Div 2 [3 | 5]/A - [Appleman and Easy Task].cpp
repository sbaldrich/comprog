#include<bits/stdc++.h>

using namespace std;

const int MM = 110;

char M[MM][MM];

int dr[] = {0, -1, 0, 1};
int dc[] = {-1,0,1,0};

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n; cin >> n;
	for( int i = 1; i <= n; i++ )
		for( int j = 1; j <= n; j++ )
			cin >> M[i][j];
	bool ok = true;
	for( int i = 1; i <= n; i++ )
		for( int j = 1,x; j <= n; j++ ){
			x = 0;
			for( int k = 0; k < 4; k++ )
				if( M[i + dr[k]][j + dc[k]] == 'o' )
					x++;
			ok &= ( x % 2 == 0 );
		}
	cout << ( ok? "YES" : "NO" ) << endl;
	return 0;
}

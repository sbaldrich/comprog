#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; scanf( "%d", &n );
	vector<int> v( n );
	int low = INT_MAX, hi = INT_MIN, c = 0, acc = 0, h = 0;
	for( int i = 0 ; i < n; i++ ){
		scanf( "%d", &v[ i ] );
		c += v[i];
		acc += ( i & 1 ? -1 : 1 ) * v[i];
		low = min( low, acc );
		hi = max( hi, acc );
	}
	int zero = abs( low );
	int ly = INT_MAX, hy = INT_MIN;
		
	vector< vector< char > > heart( 2010, vector<char>( c, ' ' ) );
	for( int i=0, j = 0, posy = zero; i<n ; i++ ){
		if( i & 1 ){
			for( int x=0; x < v[i] ; x++ ){
				heart[--posy][j++] = '\\';
			}
		}
		else{
			for( int x=0; x < v[i] ; x++ ){
				heart[ posy++ ][j++] = '/';
				cout << "pos: " << posy << endl;
			}
		}
		ly = min( ly, posy );
		hy = max( hy, posy );
	}
	for( int i=hy-1; i>=max(ly - zero,0); i-- ){
		for( int j=0; j<c; j++ )
			printf("%c", heart[i][j] );
		puts("");
	}
		
	return 0;
}

#include <bits/stdc++.h>

using namespace std;

int T, N;

void tobin( int msk ){
	for( int i=0; i<N; i++ )
		cout << ( msk & (1 << i) ? 1 : 0 );

}

bool valid_tree( const vector< int > &graph, int mask ){
	cout << "msk "; tobin( mask );
	cout << endl;
	for( int i=0, x; i<N; i++ ){
		x = __builtin_popcount( graph[i] ^ mask  );
		cout << "test " << graph[ i ] << " ^ " << mask << " = ";
		tobin( graph[i] ^ mask );
		cout << " -> " << x << endl;
		if( x != 2 && x != 1 ){
			return false;
		}
	}
	return true;
}

int main(){
	cin >> T;
	for( int caze=1; caze<=T; caze++ ){
		cin >> N;
		vector< int > graph ( N );
		for( int i=0, x, y; i<N-1; i++ ) {
			cin >> x >> y;
			x--, y--;
			graph[ x ] |= ( 1 << y );
			graph[ y ] |= ( 1 << x );
		}
		for( int i=0; i<N; i++ ){
			cout << "node " << i << " ";
			tobin( graph[i] );
			cout << endl;
		}
		int lim = (1 << N), ans = 100;
		for( int msk = 0; msk < lim; msk++ ){
			if( valid_tree( graph, msk ) ){
				cout << "valid! " << endl;
				ans = min( ans, __builtin_popcount( msk ) );
			}
		}
		cout<< "Case " << caze <<": " << ans << endl;
	}
	return 0;	

}

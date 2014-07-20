#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> ii;

map<ii, int> memo;

int f( int m, int n, int k ){
	//printf("f( %d, %d, %d )\n", m, n , k);
    :q
    :q
    :q
	if( k > m + n - 2 )
		return -1;
	if( !k )
		return m * n;
	if( memo.count( ii(m,n) ) )
		return memo[ ii(m,n) ];
	int best = 1;
	for( int i = 1; i <= k; i++ ){
		if( i >= m || i >= n )
			break;
		best = max( best, max ( f( m / ( i + 1 ), n, k - i ), f( m, n / ( i + 1 ), k - i ) ) );
	}
	return memo[ ii( m, n) ] = best;
}

int main(){
	int m, n, k; cin >> m >> n >> k;
	cout << f( m, n, k ) << endl; 
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

const int M = 1e5 + 10;
bool np[M];
vector<int> primes;

void gen_primes( ){
	for( int i = 2; i < M; i++ ){
		if( !np[ i ] ){
			primes.push_back( i );
			if( i < sqrt(M) + 1 )
				for( int j = i*i; j < M; j += i ){
					np[ j ] |= true;
			}
		}
	}
}

int find_index( int distance ){
	int l = 0, h = primes.size() - 1, m;
	do{
		m = ( l + h + 1 ) / 2;
		if( primes[m] == distance )
			return distance;
		else if( primes[m] < distance )
			l = m;
		else h = m-1;
	} while( l < h );
	return primes[l];
} 

int main(){
	gen_primes( );
	int n; cin >> n;
	vector<int> v( n + 1 ), pos( n + 1 );
	for( int i = 1; i <= n; i++ ){
		cin >> v[i];
		pos[v[i]] = i;
	}
	int distance, index, nops = 0;
	vector< pair<int, int> > ops;
	for( int i = 1; i <= n; i++ ){
		distance = pos[i] - i;
		while( distance ){
			index = find_index( distance + 1 ) - 1;
			nops++;
			ops.push_back( make_pair( pos[i], pos[i] - index) );
			swap( v[ pos[i] ] , v[ pos[i] - index ] );
			swap( pos[i], pos[ v[ pos[i] ] ] );
			distance = pos[i] - i;
		}
	}
	cout << nops << endl;
	for( int i = 0; i < nops; i++ )
		cout << ops[i].second << " " << ops[i].first << endl;
	
	return 0;
}

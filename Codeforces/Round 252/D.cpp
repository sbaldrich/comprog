#include<bits/stdc++.h>

using namespace std;

typedef pair< int, int > ii;
int main(){
	int n, sw = 0, m; cin >> n;
	vector<int> pos( n+1 ), v( n+1 );
	vector< ii > ans;
	for( int i=1; i <= n; i++ ){
		cin >> v[i];
		pos[ v[i] ] = i;
	}
	cin >> m;
	for( int i = 2; i <= n; i++ )
		for( int j = i-1; j > 0; j-- )
			sw += v[i] < v[j];
	if( m < sw ){
		for( int i = 1 ; i < n; i++ ){
			if( pos[i] != i ){
				ans.push_back( ii( i, pos[i] ) );
				swap( v[i], pos[i] );
				swap( pos[i], pos[ v[i] ] );
				sw--;
				if( sw == m )
					break;
			}
		}
	}
	else if( m > sw ){
		for( int i = 2 ; i < n; i++ ){
			if( pos[i] == i ){
				ans.push_back( ii( 1, pos[i] ) );
				swap( v[i], pos[i] );
				swap( pos[i], pos[ v[i] ] );
				sw++;
				if( sw == m )
					break;
			}
		}
	}
	int nn = (int)  ans.size();
	cout << nn << endl;
	if( nn ){
		for( int i = 0; i<nn; i++ )
			cout << (i ? " ": "" ) << ans[i].first << " " << ans[i].second;
		cout << endl;
	}

		
	
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

typedef pair< int, int > ii;

int main(){
	int n, m; cin >> n >> m;
	int ans = 0;
	vector< ii > nodes;
	vector< int > graph[ n ], cost( n );
	vector< bool > dead( n, false );
	set< ii > s; 
	for( int i = 0, node; i < n; i++ ){
		cin >> cost[i];
		s.insert( ii( cost[i], i ) );
	}
	for( int i = 0, fr, to; i < m; i++ ){
		cin >> fr >> to;
		fr--; to--;
		graph[fr].push_back( to );
		graph[to].push_back( fr );

	}
	for( typeof( s.rbegin() ) it = s.rbegin(); it != s.rend(); it++ ){
		int node = it -> second;
		for( int i = 0; i < ( int )graph[ node ].size(); i++ ){
			if( !dead[ graph[ node ][ i ] ] ){
				ans += cost[ graph[node][i] ];
			}
		}
		dead[ node ] = true;
	}
	cout << ans << endl;

	return 0;
}

#include<bits/stdc++.h>

using namespace std;

const int M = 1e5 + 5;
int d[M], bad[M];
bool seen[M];

int f( int node, const vector<int>* g ){
	if( seen[node]++ )
		return 0;
	d[ node ] = bad[ node ];
	for( int i = 0,x; i < g[node].size(); i++ )
		d[ node ] += f( g[node][i], g );
	return d[ node ];
}

int main(){
	int n; cin >> n;
	vector<int> g[n];
	for( int i = 0, fr, to, b; i < n-1; i++ ){
		cin >> fr >> to >> b;
		fr--; to--;
		g[ fr ].push_back( to );
		g[ to ].push_back( fr );
		--b;
		bad[ fr ] |= b;
		bad[ to ] |= b;
	}

	f( 0, g );

	vector<int> ans;
	for( int i = 0; i < n; i++ )
		if( bad[i] && d[i] == 1 )
			ans.push_back( i+1 );
	cout << ans.size() << endl;
	for( int i = 0; i < ans.size(); i++ )
		cout << ans[i] << ( i < ans.size() - 1 ? " ": "\n" ) ;
	return 0;
}

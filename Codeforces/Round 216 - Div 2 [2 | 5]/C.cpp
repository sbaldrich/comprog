#include<bits/stdc++.h>

using namespace std;

map<int,bool> prob;

vector<int> ans;

void dfs( int node, bool problem, set<int> *graph ){
	if( graph[node].empty() ){
		if( problem )
			ans.push_back( node + 1 );
		return;
	}
	for( set<int> :: iterator it = graph[node].begin(); it != graph[node].end(); it++ )
		dfs( *it, problem | prob[ *it ], graph );
}

int main(){
	int n; cin >> n;
	set<int> g[ n ];
	for( int fr, to, p, i = 0; i < n - 1; i++ ){
		cin >> fr >> to >> p;
		--fr; --to;
		if( fr > to )
			swap( fr, to );
		g[ fr ].insert( to );
		prob[to] = p - 1 ? true : false;
	}
	dfs( 0, false, g );
	cout << ans.size() << endl;
	for( int i = 0; i < ans.size(); i++ )
		cout << ( i ? " " : "" ) << ans[i];
	return 0;
}

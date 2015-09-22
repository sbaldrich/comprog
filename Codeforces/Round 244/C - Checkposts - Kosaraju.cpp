/*
 * Codeforces Round 244 div 2 problem C - Checkposts. Based on niquefa_diego's solution.
 */

#include<bits/stdc++.h>

using namespace std;

const int M = 100010;
const int MOD = 1000000007;

typedef long long ll;

vector<int> in[M] , out[M];
stack<int> st;
int cost[M];
bool seen[M] = {0};

void build_stack( int n ){
	if( seen[n]++ )
		return;
	for( int i=0; i < (int) out[n].size(); i++ )
		build_stack( out[n][i] );
	st.push( n );
}

vector<int> comp;
void get_comp( int n ){
	if( seen[ n ] ++ )
		return;
	for( int i=0; i < (int) in[n].size(); i++ )
		get_comp( in[n][i] );
	comp.push_back( cost[n] );
}

int main(){
	int n,m; cin >> n;
	for( int i=0; i<n; i++ )
		cin >> cost[i];
	cin >> m;
	for( int i=0,f,t; i<m; i++ ){
		cin >> f >> t;
		f--,t--;
		in[t].push_back( f );
		out[f].push_back( t );
	}

	for( int i=0; i<n; i++ )
		if( !seen[i] )
			build_stack( i );
	memset( seen, false, sizeof( seen ) );
	
	ll ways = 1, min_cost = 0;
	while(!st.empty() ){
		int x = st.top();
		st.pop();
		if( seen[x] )
			continue;
		get_comp( x );
		
		sort( comp.begin(), comp.end() );
		
		min_cost += comp[0];
		int y = count( comp.begin(), comp.end(), comp[0] );
		ways = ways * (ll)y % MOD;
		
		comp.clear();
	}
	cout << min_cost << " " << ways << endl;
	return 0;
}

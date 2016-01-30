#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

const ll MOD = 1000000007;
const int M = 100010;

int ind[M], low[M], price[M], idx = 0, top;
vector<int> comp, g[M];
stack<int> st;
bool in_stack[M] = { 0 };

ll ways = 1LL, min_cost = 0LL;

void solve( int p ){
	ind[p] = low[p] = idx++;
	st.push( p );
	in_stack[p]++; 
	for( int i=0; i<g[p].size(); i++ ){
		int &q = g[p][i];
		if( ind[q]  == -1 ){
			solve( q );
			low[p] = min( low[p], low[q] );
		}
		else if( in_stack[q] )
			low[p] = min( low[p], ind[q] );
	}
	if( ind[p] == low[p] ){
		do{
			top = st.top( );
			st.pop( );
			in_stack[top] = false;
			comp.push_back( price[top] );
		} while( p != top );
		sort( comp.begin(), comp.end() );
		int times = count( comp.begin(), comp.end(), comp[0] );
		min_cost += comp[0];
		ways = ways * (ll)times % MOD;
		comp.clear();
	}
}

int main(){
	int n,m; cin >> n;
	for( int i=0; i<n; i++ )
		cin >> price[i];
	cin >> m;
	for( int i=0, fr, to; i<m; i++ ){
		cin >> fr >> to;
		fr--,to--;
		g[fr].push_back( to );	
	}
	
	memset( ind, -1, sizeof( ind ) );
	
	for( int i=0; i<n; i++ )
		if( ind[i] == -1 )
			solve( i );
	
	cout << min_cost << " " << ways << endl;
	return 0;
}

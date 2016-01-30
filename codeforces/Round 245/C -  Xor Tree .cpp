#include<bits/stdc++.h>

using namespace std;

const int M = 100010;
vector< int > g[M], ans;
bool goal[M], cur[M], seen[M];

void solve( int x, bool odd = true, bool flip_odd = false, bool flip_even = false ){
	if( seen[x] ++ )
		return;
	if( odd ){
		if( ( !flip_odd && ( cur[x] != goal[x] ) ) || ( flip_odd && ( cur[x] == goal[x] ) )	){
			ans.push_back(x);
			flip_odd = !flip_odd;
		}
	}
	else{
		if( ( !flip_even && ( cur[x] != goal[x] ) ) || ( flip_even && ( cur[x] == goal[x] ) ) ){
			ans.push_back(x);
			flip_even = !flip_even;
		}
	}
	for( int i=0; i < ( int )g[x].size(); i++ )
		solve( g[x][i], !odd, flip_odd, flip_even ); 
}

int main(){
	int n; cin >> n;
	for( int i=0, fr, to; i < n-1; i++ ){
		cin >> fr >> to;
		g[ fr ].push_back( to );
		g[ to ].push_back( fr );
	}
	for( int i = 1; i <= n; i++ )
		cin >> cur[i];
	for( int i = 1; i <= n; i++ )
		cin >> goal[i];
	solve( 1 );
	cout << ans.size() << endl;
	for( int i = 0; i < (int) ans.size(); i++ )
		cout << ans[i] << endl;
	return 0;
}

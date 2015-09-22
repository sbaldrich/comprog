#include<bits/stdc++.h>
#define d( x, y )  cout << "{ " << #x << ", " << #y << " } = { " << x << ", " << y << " }" << endl 
using namespace std;

const int M = 5010;

typedef long long ll;
vector<ll> v, s;
ll dp[M][M];
int n,m,k;

ll f( int l, int k ){
	if( dp[l][k] != -1 )
		return dp[l][k];
	if( k == 0 )
		return 0;
	if( n - l <= m )
		return dp[l][k] = s[n-1] - ( l ? s[l-1] : 0 );
	return dp[l][k] = max( s[l + m - 1] - ( l ? s[l-1] : 0 ) + f( l+m, k-1 ), f( l+1, k) );
}

int main(){
	cin >> n >> m >> k;
	memset( dp, -1, sizeof( ll ) * M * M );
	v.resize(n); s.resize(n);
	for( int i = 0; i < n; i++ ){
		cin >> v[i];
		s[i] = v[i];
		if( i )
			s[i] += s[i-1];
	}
	cout << f( 0, k ) << endl;
	return 0;
}

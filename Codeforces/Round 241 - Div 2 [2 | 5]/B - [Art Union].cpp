#include<bits/stdc++.h>

using namespace std;
const int M = 50010;
:Sa
int dp[M][6];
int t[6][M];
int main(){
	int m, n; cin >> m >> n;
	for( int i = 0; i <= m; i++ )
		dp[i][0] = 0;
	for( int i = 0; i <= n; i++ )
		dp[0][i] = 0;
	for( int i = 1; i <= m; i++ )
		for( int j = 1; j <= n; j++ )
			cin >> t[j][i];
	for( int i = 1; i <= m; i++ )
		dp[i][1] = dp[i-1][1] + t[1][i];
	for( int j = 2; j <= n; j++ )
		for( int i = 1; i <= m; i++ )
			dp[i][j] = max( dp[i-1][j], dp[i][j-1] ) + t[j][i];
	for( int i = 1; i <= m ; i++ )
		cout << ( i - 1 ? " " : "" ) << dp[i][n];
	cout << endl;
	
	return 0;
}

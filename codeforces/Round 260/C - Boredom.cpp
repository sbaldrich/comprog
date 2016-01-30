#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

const int M = 100010;

int cnt[M];
ll dp[M];

int main(){
	int n; cin >> n;
	for( int i = 0, x; i < n; i++ ){
		cin >> x;
		cnt[x+2]++;
	}
	for( int i = 2; i < M; i++ )
		dp[i] = max( dp[i-1], ll( i-2 ) * ll( cnt[i] ) + dp[i-2]  );
	cout << dp[M-1] << endl;
	return 0;
}

/*
 * Created on: Feb 3, 2012
 * Author: sbaldrich ( Special thanks to ajmarin and vudduu )
 * Problem B - Ball Stacking
 * Source: Latin America Regional contest 2011
 *
 * Dynamic Programming. The code speaks for itself. (I guess)
 */


#include<cstdio>

using namespace std;

#define max(a , b) (a)>(b)?(a):(b)
typedef long long LL;
const int N = 1002;
LL dp[N][N];

void dump(int n) {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			printf("%4lld", dp[i][j]);
		}
		printf("\n");
	}
}

int main() {
	//freopen("B.in", "r", stdin);
	LL ans;
	for (int n; scanf("%d", &n) == 1 && n;) {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++) {
				scanf("%lld", &dp[i][j]);
				dp[i][j] += dp[i - 1][j];
			}
		ans = 0LL;
		for(int col=1;col<=n;col++)
		{
			for(int row=col;row<=n;++row)
				dp[row][col]+=dp[row-1][col-1];
			for(int row=n-1;row>=col;--row)
				dp[row][col] = max(dp[row+1][col],dp[row][col]);
			ans = max(ans,dp[col][col]);
		}
		printf("%lld\n" , ans);
	}
	return 0;
}



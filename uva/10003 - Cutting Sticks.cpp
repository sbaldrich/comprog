#include<cstdio>

const bool debug = true;
#define min(a,b) (a) < (b) ? (a) : (b) 

int c[55], dp[55][55];

int f(int l, int r){
	if( l + 1 == r) 	return 0;
	if(dp[l][r] != -1)  return dp[l][r];
	int ans = 1e8,cost = 0;
	for(int i=l+1, x, y, z;i<r;i++)
		ans = min(ans, f(l,i) + f(i, r) + c[r] - c[l]);
	return dp[l][r] = ans;
}

int main(){
	//freopen("aa.in", "r", stdin);
	int n,l;
	while(scanf("%d %d", &l, &n) && l){
		for(int i=1; i<=n; i++)
			scanf("%d", &c[i]);
		c[0] = 0; c[n + 1] = l;
		for(int i=0; i<=n+1 ;i++)
			for(int j=0; j<=n+1; j++)
				dp[i][j] = -1; 
		printf("The minimum cutting is %d.\n", f(0,n+1));
	}
	return 0;
}

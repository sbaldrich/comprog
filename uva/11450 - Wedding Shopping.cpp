#include<cstdio>

using namespace std;

const bool debug = true;
#define max(a,b) (a) > (b) ? (a) : (b) 

const int oo = 1 << 10;
int dp[25][210];
int budget, garments, price[25][25];

int f(int p, int money){ //Item type on consideration ( p <= c ) , money spent so far.
	if(money > budget)
		return -oo;
	if( p == garments )
	 	return money;
	if( dp[p][money] != -1)
		return dp[p][money];
	int ans = -oo;
	for(int i=1, c;i <= price[p+1][0]; i++){
		c = f(p+1, price[p+1][i] + money);
		ans = max(ans, c);
	}
	return dp[p][money] = ans;
}	

int main(){
	freopen("aa.in" , "r", stdin);	
	int n,k,ans;
	scanf("%d" , &n);
	for(int tc = 1; tc <=n; tc++){
		scanf("%d %d" , &budget, &garments);
		for(int i = 1; i <= garments; i++){
			scanf("%d" , &k);
			price[i][0] = k;
			for(int j=1; j<=k; j++)
				scanf("%d" , &price[i][j]);
		}
		for(int i = 0; i <= garments; i++)
			for(int j = 0; j <= budget; j++)
				dp[i][j] = -1;
		ans = f(0,0);
		if(ans < 0)
			printf("no solution");
		else printf("%d", ans);
		puts("");
	}
	return 0;
}



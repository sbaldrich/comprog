#include<iostream>
#include<cstring>

using namespace std;

int dp[8000][8000];
int s[]={0 , 1, 5, 10, 25, 50};

int f(int n, int i)
{
	if(n <= 0)
			return (n==0?1:0);
	if(dp[n][i]!=-1)
		return dp[n][i];
	if(i<=0 && n>0)
		return 0;
	dp[n][i] = f(n,i-1) + f(n-s[i],i);
	return dp[n][i];
}

int main()
{
//	freopen("674.in" , "r" , stdin);
	int x;
	memset(dp,-1,sizeof(dp));
	while(cin>> x)
		cout <<f(x,5)<<endl;

	return 0;
}

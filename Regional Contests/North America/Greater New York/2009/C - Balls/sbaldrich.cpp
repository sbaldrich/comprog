/*
 * Created on: 07/11/2011
 * Author:  sbaldrich
 * Problem: Balls
 * Source:  South America Regional Contest 2000
 */

#include<iostream>
#include<cstring>

using namespace std;

int memo[51][1001];

int solve(int b, int f)
{
	if(memo[b][f]>=0)
		return memo[b][f];
	int ans = f;
	for(int i=1;i<=f;i++)
	{
		int l = solve(b-1,i-1) , r = solve(b,f-i);
		int aux =  1 + (l>r?l:r);
		ans = ans < aux? ans:aux;
	}
	return memo[b][f] = ans;
}

int main()
{
	//freopen("C.in" , "r" , stdin);
	int P , c ,B, M;
	cin>>P;
	memset(memo,-1,sizeof(memo));

	for(int i=0;i<=1000;i++)
		memo[1][i] = i;

	for(int i=2;i<=50;i++)
		memo[i][1] = 1,memo[i][0]=0;

	/*for(int i=1;i<=10;i++)
		for(int j=1;j<=10;j++)
			cout.width(3),cout << memo[i][j]<<" "<<(j<10?" ":"\n");*/

	for(int i=0;i<P;i++)
	{
		cin>>c>>B>>M;
		cout << c << " " << solve(B,M)<<endl;
	}
	return 0;
}




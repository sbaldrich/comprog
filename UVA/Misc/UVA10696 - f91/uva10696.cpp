#include<algorithm>
#include<iostream>
#include<vector>
#include<map>
#include<set>
#include<queue>
#include<sstream>
#include<cstring>
#include<cstdlib>
#include<cstdio>
#include<string>
#include<cmath>

using namespace std;

#define oo                 INT_MAX
#define fi(n,i)             for(int (i)=0;(i)<(n); (i)++)
#define fs                  first
#define sc                  second
#define all(c)              (c).begin(),(c).end()
#define halt                system("pause > nul")

int dp[200][200];

int C(int n, int k)
{
    if(n == k || k==0)
        return 1;
    if( dp[n][k]!= -1)
        return dp[n][k];
    dp[n][k] = C(n-1,k-1) + C(n-1 , k);
    return dp[n][k];
}

int main()
{
    
   // freopen("g.in"  , "r" , stdin);
//    freopen("g.out" , "w" , stdout);
    
    memset(dp,-1,sizeof(dp));
    int n,k;
    while(cin>>n>>k && n && k)
         cout << n<<" things taken "<<k<<" at a time is "<<C(n,k)<<" exactly."<<endl;
    
    return 0;
}

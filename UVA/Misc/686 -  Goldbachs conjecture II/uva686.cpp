#include<iostream>
#include<vector>
#include<cstring>
#include<cmath>

using namespace std;

int main()
{
   //freopen("uva686.in" , "r"  ,stdin);
   //freopen("uva686.out" , "w"  ,stdout);
   
   bool prime[330000];
   memset(prime , true , sizeof(prime));
   prime[0] = prime[1] = false;
   int maxP = sqrt(33000);
   for(int i=2;i<maxP + 1;i++)
       if(prime[i])
          for(int j=i*i;j<33000;j+=i)
              prime[j] = false;
   
   int n;
   while(cin>>n && n)
   {
     int ans = 0;
     for(int i=0;i<=n/2;i++)
         if(prime[i] && prime[n-i])
            ans++;
     cout << ans << endl;             
   }
   return 0;
}


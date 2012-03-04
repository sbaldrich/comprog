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

typedef map<int,int> prime_map ;
void squeeze(prime_map &M , int &n , int p){ for(;n%p == 0;n/=p) M[p]++;} 

prime_map factor(int n)
{
    prime_map M;
    if(n<0)
        return factor(-n);
    if(n<2)
        return M;
    squeeze(M,n,2);squeeze(M,n,3);    
    int maxP =(int) sqrt(n) + 2;
    for(int p=5;p<maxP;p+=6)
        squeeze(M,n,p),squeeze(M,n,p+2);
    if(n>1)
        M[n]++;
    return M;    
}

prime_map operator+(prime_map &a , prime_map &b)
{
    prime_map :: iterator ita=a.begin() , itb = b.begin();
    prime_map ans;
    for(ita = a.begin(); ita!=a.end();ita++)
        ans[(*ita).fs]+=(*ita).sc;
    for(itb = b.begin(); itb!=b.end();itb++)
        ans[(*itb).fs]+=(*itb).sc;    
    return ans;
}


int main()
{
    //freopen("uva160.in"  , "r" , stdin);
//    freopen("uva160.out" , "w" , stdout);

    vector< prime_map > maps(110);
    for(int i=2;i<=100;i++)
        maps[i] = factor(i);
  
        
    int n;
    while(cin>>n && n)
    {
        prime_map ans;
        for(int i=2;i<=n;i++)
            ans = ans+maps[i];    
        prime_map :: iterator it=ans.begin();
        
        //Stupid output formatting conditions begin here
        cout.width(3);
        cout << n;
        cout << "! =";
        int i=1,q = ans.size();
        for(it=ans.begin(); it!=ans.end();it++,i++)
        {
            cout.width(3),cout <<(*it).sc;
            if(i==15 && i<q)
                cout << endl,cout.width(6),cout<<"",i=1;    
        }
        cout << endl;
    }

    return 0;
}

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

int main()
{
//    freopen("c.in"  , "r" , stdin);
//    freopen("c.out" , "w" , stdout);
    
    string s;
    while(cin>>s && s!="0")
    {
        int n=0, l=s.size();
        for(int i=1;i<=l;i++)
            n+=(s[l-i]-'0')*(pow(2.0,i)-1);
        cout << n << endl;    
    }
    return 0;
}

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

int m[1000010];

int f(int n)
{
    if(m[n]!=-1)
        return m[n];
    if(n>=101)
        m[n] = n-10;
    else
        m[n] = f(f(n+11));
    return m[n];   
}

int main()
{
    //freopen("E.in"  , "r" , stdin);
//    freopen("E.out" , "w" , stdout);
    memset(m , -1 , sizeof(m));
    int n;
    while(cin>>n && n)
        cout << "f91("<<n<<") = "<<f(n) << endl;

    return 0;
}

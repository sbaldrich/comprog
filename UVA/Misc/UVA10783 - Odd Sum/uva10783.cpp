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
//    freopen("B.in"  , "r" , stdin);
//    freopen("B.out" , "w" , stdout);
    
    int c , a, b,s;
    
    cin>> c;
    for(int t=1;t<=c;t++)
    {
        s = 0;
        cin>>a>>b;
        for(int i=a;i<=b;i++)
            if(i%2 ==1)
                s+=i;
        cout << "Case "<<t<<": "<<s << endl;    
    }
    

    return 0;
}

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

#define oo                  INT_MAX
#define fi(n,i)             for(int (i)=0;(i)<(n); (i)++)
#define fs                  first
#define sc                  second
#define all(c)              (c).begin(),(c).end()
#define halt                system("pause > nul")

int main()
{
    //freopen("uva10340.in"  , "r" , stdin);
//    freopen("uva10340.out" , "w" , stdout);

    string s , t;
    while(cin>>s>>t)
    {
        bool subs = true;
        fi(s.size(),i)
        {
            if(t.find(s[i]) == string::npos)
            {
                subs = false;
                break;
            }
            t.erase(0 , t.find(s[i])+1);
        }
        cout << (subs?"Yes":"No")<<endl;    
        
    }
    return 0;
}

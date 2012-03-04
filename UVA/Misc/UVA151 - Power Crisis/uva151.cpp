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
    //freopen("uva151.in"  , "r" , stdin);
    //freopen("uva151.out" , "w" , stdout);

    int n;
    vector<bool> stations;
    while(cin>>n && n)
    {
        bool found = false;
        for(int m=1;;m++)
        {
            stations = vector<bool>(n,true);
            int stleft = n;     
            int t = 0;
            while(stleft)
            {
                if(t == 12)
                {
                    if(stleft == 1)
                        found = true;
                    break;    
                }
                if(stations[t])
                    stations[t] = false , stleft--;    
                int c = 0;
                while(c<m)
                {
                    t=(t+1)%n;
                    if(stations[t])
                        c++;    
                }
            }
            if(found)
            {
                 cout << m << endl;
                 break;    
            }
            
        }        
    
    }
    return 0;
}

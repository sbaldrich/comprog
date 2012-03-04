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
    //freopen("uva10370n.in"  , "r" , stdin);
    //freopen("uva10370.out" , "w" , stdout);

    int C , n , avg, x;
    vector<int> v;
    scanf("%d",&C);
    while(C--)
    {
        avg = x = 0;
        
        scanf("%d" , &n);
        v = vector<int>(n);
        fi(n,i)
            scanf("%d" , &v[i]),avg+=v[i];
        avg /= n;
        fi(n,i)
            if(v[i]>avg)
                x++;
        double ans = x*100.0/(double)n;
        printf("%.3f%%\n"  ,ans);
    }

    return 0;
}

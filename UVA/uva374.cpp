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

template <class T>
T powerMod(T b, T p, T m) {
	T result = 1;
	while (p > 0) {
		if (p & 1)
			result = (result*b) % m;
		p >>= 1;
        b = (b*b)%m;
	}
	return result;
}
int main()
{
   // freopen("uva374.in"  , "r" , stdin);
//    freopen("uva374.out" , "w" , stdout);
    long long b,p,m;
    while(cin>>b>>p>>m)
        cout << powerMod(b,p,m)<<endl;


    return 0;
}

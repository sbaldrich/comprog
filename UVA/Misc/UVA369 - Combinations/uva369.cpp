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
#include<numeric>
#include<functional>

using namespace std;

#define oo                 INT_MAX
#define fi(n,i)             for(int (i)=0;(i)<(n); (i)++)
#define fs                  first
#define sc                  second
#define pb                  push_back
#define all(c)              (c).begin(),(c).end()
#define halt                system("pause > nul")

vector<int> divisors;

string f(int n)
{
    if(n<2)
        return "DEFICIENT";
    divisors.clear();
    divisors.pb(1);
    for(int i=2;i<n;i++)
        if(n%i==0)
            divisors.pb(i);
    int s = accumulate(all(divisors),0);
    if(s<n)
        return "DEFICIENT";
    if(s>n)
        return "ABUNDANT";
    else return "PERFECT";    
}

int main()
{
    //freopen("ff.in"  , "r" , stdin);
    //freopen("f.out" , "w" , stdout);

    int N;
    cout << "PERFECTION OUTPUT"<<endl;
    while(cin>>N && N)
    {
        cout.width(5);
        cout << N;  
        cout <<"  "<<f(N)<<endl;    
    }
    cout << "END OF OUTPUT"<<endl;
    

    return 0;
}

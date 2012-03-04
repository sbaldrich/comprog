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
#define fi(n,i)            for(int (i)=0;(i)<(n); (i)++)
#define fs                 first
#define sc                 second
#define all(c)             (c).begin(),(c).end()
#define halt               system("pause > nul")


bool f(pair<char, int> a , pair<char,int> b)
{
    if(a.sc > b.sc)
        return true;
    return (a.fs < b.fs);
}

int main()
{
//    freopen("A.in"  , "r" , stdin);
//    freopen("A.out" , "w" , stdout);
   
    string alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    map<char , int> M;
    vector< pair<char,int> > V;
    int n;
    cin>>n;
    string str , s;
    while(cin>>s)
        str+=s;
    transform(all(str) , str.begin() , ::toupper);
    fi((int)str.size() , i)
    {
        if(alpha.find(str[i]) == string:: npos)
            continue;
        M[str[i]]++;    
    }
    V = vector<pair <char,int> >(all(M));
    sort(all(V),f);
    fi((int)V.size() , i)
        cout << V[i].fs << " " << V[i].sc<<endl;
    return 0;
}

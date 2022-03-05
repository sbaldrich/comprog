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
#include<stack>

using namespace std;

#define oo                 INT_MAX
#define fi(n,i)             for(int (i)=0;(i)<(n); (i)++)
#define fs                  first
#define sc                  second
#define all(c)              (c).begin(),(c).end()
#define halt                system("pause > nul")

    int pos[50];
void f( stack<int> &s)
{
    int x;
    while(!s.empty())
        x = s.top(), s.pop() , f(s), cout <<" " << x;    

}

void dump(vector< stack<int> > s , int n)
{
    fi(n,i)
    {
        cout << i <<":"; 
        if(!s[i].empty())
            f(s[i]);
        cout << endl;    
    }
    cout << "***" << endl;
    fi(n,i)
        cout << i << ":" << pos[i] << endl;
}

int main()
{
    //freopen("uva101.in"  , "r" , stdin);
    //freopen("uva101.out" , "w" , stdout);
    
    int  n , a, b;
    string command , way;
    cin>>n;
    if(n<1)
        return 0;
    
    vector< stack<int> > stacks(n,stack<int>());
    stack<int> aux;

    fi(n,i)
        pos[i] = i , stacks[i].push(i);
    
    while(cin>>command && command != "quit" )
    {
        cin>> a >> way >> b;
        //cout << command <<" " << a << " " <<way << " "<< b << endl;
        if(a > n-1 || b > n-1 || a == b || a<0 || b <0 || pos[a] == pos[b])
            continue;
        if(command == "move")
        {
           while(stacks[pos[a]].top() != a)
           {
                stacks[stacks[pos[a]].top()].push(stacks[pos[a]].top());
                pos[stacks[pos[a]].top()] = stacks[pos[a]].top();
                stacks[pos[a]].pop();    
                
            }
            if(way == "onto")
            {
                while(stacks[pos[b]].top() != b)
                {
                    stacks[stacks[pos[b]].top()].push(stacks[pos[b]].top());
                    pos[stacks[pos[b]].top()] = pos[stacks[pos[b]].top()];
                    stacks[pos[b]].pop();    
                }    
            }
            stacks[pos[b]].push(a);
            stacks[pos[a]].pop();    
            pos[a] = pos[b];
        
        }
        
        else if(command == "pile")
        {
           while(stacks[pos[a]].top() != a)
           {
                aux.push(stacks[pos[a]].top());
                pos[stacks[pos[a]].top()] = pos[b];
                stacks[pos[a]].pop();
           }
           if( way == "onto")
           {
                while(stacks[pos[b]].top() != b)
                {
                    stacks[stacks[pos[b]].top()].push(stacks[pos[b]].top());
                    pos[stacks[pos[b]].top()] = pos[stacks[pos[b]].top()];
                    stacks[pos[b]].pop();    
                }   
           }
           aux.push(a);
           stacks[pos[a]].pop();
           pos[a] = pos[b];
           while(!aux.empty())
           {
                stacks[pos[b]].push(aux.top());
                aux.pop();       
            }
        }
    //dump(stacks, n);        
    }
    fi(n,i)
    {
        cout << i <<":";
        if(!stacks[i].empty())
            f(stacks[i]);
        if(i<n-1)
            cout << endl;    
    }
    return 0;
}

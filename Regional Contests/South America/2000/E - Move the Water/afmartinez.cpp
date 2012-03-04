#include <map>
#include <set>
#include <queue>
#include <algorithm>
#include <utility>
#include <iostream>

#define mp make_pair
#define sc second
#define fs first

using namespace std;

typedef pair<int,pair<int,int> > tr;

tr a,b,c;
map<int,tr> m;
set<int> v;

int bfs(int st,int fn){
    queue<pair<int,int> > q;
    v.clear();
    pair<int,int> curr;
    tr t,x;
    int d,k;
    q.push(mp(st,0));
    while(!q.empty()){
        curr=q.front();
        if(curr.fs==fn)
            return curr.sc;
        q.pop();
        v.insert(curr.fs);
        x=m[curr.fs];
        if(x.fs<c.fs){
            t=x;
            d=min(t.sc.fs,(c.fs-t.fs));
            t.sc.fs-=d;
            t.fs+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
            t=x;
            d=min(t.sc.sc,(c.fs-t.fs));
            t.sc.sc-=d;
            t.fs+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
        }
        if(x.sc.fs<c.sc.fs){
            t=x;
            d=min(t.fs,(c.sc.fs-t.sc.fs));
            t.fs-=d;
            t.sc.fs+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
            t=x;
            d=min(t.sc.sc,(c.sc.fs-t.sc.fs));
            t.sc.sc-=d;
            t.sc.fs+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
        }
        if(x.sc.sc<c.sc.sc){
            t=x;
            d=min(t.fs,(c.sc.sc-t.sc.sc));
            t.fs-=d;
            t.sc.sc+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
            t=x;
            d=min(t.sc.fs,(c.sc.sc-t.sc.sc));
            t.sc.fs-=d;
            t.sc.sc+=d;
            k=(t.fs*250000)+(t.sc.fs*500)+t.sc.sc;
            m[k]=t;
            if(!v.count(k)){
                q.push(mp(k,curr.sc+1));
                v.insert(k);
            }
        }
    }
    return -1;
}

int main(){
    //freopen("move_the_water.in","r",stdin);
    //freopen("move_the_water.out","w",stdout);
    int Sa,Sb,Sc,k1,k2;
    while(cin>>c.fs>>c.sc.fs>>c.sc.sc>>a.fs>>a.sc.fs>>a.sc.sc>>b.fs>>b.sc.fs>>b.sc.sc && c.fs){
        Sa=a.fs+a.sc.fs+a.sc.sc;
        Sb=b.fs+b.sc.fs+b.sc.sc;
        Sc=c.fs+c.sc.fs+c.sc.sc;
        if(Sc<Sb || Sa!=Sb)
            cout<<-1<<endl;
        else{
            k1=(a.fs*250000)+(a.sc.fs*500)+a.sc.sc;
            m[k1]=a;
            k2=(b.fs*250000)+(b.sc.fs*500)+b.sc.sc;
            m[k2]=b;
            cout<<bfs(k1,k2)<<endl;
        }
    }
    return 0;
}

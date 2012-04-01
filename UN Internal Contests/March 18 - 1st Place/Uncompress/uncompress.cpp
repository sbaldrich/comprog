#include<cstdio>
#include<cstdlib>
#include<iostream>
#include<string>
#include<set>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    /*
     * freopen("245.in","r",stdin);
     * freopen("245.out","w",stdout);
     *
     */
    char c;
    string s="",n="",val;
    vector<string> v;
    set<string> st;
    int pos;
    while(scanf("%c",&c) && c!='0'){
        if((c>='a' && c<='z') || (c>='A' && c<='Z'))
            s+=c;
        else if(c>='1' && c<='9')
            n+=c;
        else{
            if(s!=""){
                cout<<s;
                if(!st.count(s)){
                    st.insert(s);
                    v.push_back(s);
                }
                s="";
            }
            if(n!=""){
                pos=v.size()-atoi(n.c_str());
                n="";
                val=v[pos];
                cout<<val;
                v.erase(v.begin()+pos);
                v.push_back(val);
            }
            cout<<c;
        }
    }
    return 0;
}




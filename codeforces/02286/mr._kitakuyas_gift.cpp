#include<bits/stdc++.h>
#define D(x) cout << #x << ": " << x << endl
using namespace std;

bool pal( string s ){
    for( int i = 0; i < s.size(); i++ )
        if( s[i] != s[s.size() - 1 - i ] )
            return false;
    return true;
}

int main(){
    
    string s,t; cin >> s;
    int n  = s.size();
    for( int pos = 0; pos <= n; pos++ ){
        t=s;
        t.insert(pos,"a");
        for( char c = 'a'; c <= 'z'; c++ ){
            t[pos] = c;
            if( pal(t) ){
                cout << t << endl;
                return 0;
            }
        }
            
    }
    cout << "NA" << endl;
    return 0;
}
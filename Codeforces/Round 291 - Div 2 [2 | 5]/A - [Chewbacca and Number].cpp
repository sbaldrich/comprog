#include<bits/stdc++.h>

using namespace std;

void f(char &c){
    int n = c-'0';
    c = ( n > 9 - n ? 9 - n : n )+ '0'; 
}
int main(){
    string s; cin >> s;
    for(int i=0; i<s.size(); i++)
        if( !(i == 0 && s[i] == '9'))
            f(s[i]);
    cout << s << endl;
    return 0;
}
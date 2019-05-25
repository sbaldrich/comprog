#include<bits/stdc++.h>

using namespace std;

bool isSubsequence( const string &s, const string &t ){
	int p = 0;
	for( int i = 0; p < s.size() && i < t.size(); i++ )
		if( t[i] == s[p] )
			p++;
	return p == s.size();
}

int main(){
	string s,t,u; cin >> s >> t;
	int sc[26] = {0}, tc[26] = {0};
	for( int i = 0; i < s.size(); i++ )
		sc[ s[i] - 'a' ]++;
	for( int i = 0; i < t.size(); i++ )
		tc[ t[i] - 'a' ]++;
	for( int i = 0; i < 26; i++ )
		if( tc[i] > sc[i] ){
			cout << "need tree" << endl;
			return 0;
		}
	if( isSubsequence( t, s ) ){
		cout << "automaton" << endl;
		return 0;
	}
	sort( s.begin(), s.end() );
	sort( t.begin(), t.end() );
	
	if( s == t ){
		cout << "array" << endl;
		return 0;
	}
	if( isSubsequence( t, s ) )
		cout << "both" << endl;
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

int main(){
	string s; cin >> s;
	if( s.size() < 2 )
		cout << ( ( s[0] - '0' ) % 4 == 0 ? 4 : 0 )<< endl;
	else{
		int x = ( s[s.size() - 2] - '0' ) * 10 + ( s[ s.size() - 1] - '0');
		if( x % 4 == 0 )
			cout << 4 << endl;
		else cout << 0 << endl;
	}
	return 0;
}

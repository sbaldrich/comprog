#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n,p; cin >> n >> p;
	string s; cin >> s;
	int index;
	bool ok = false;
	for( index = n - 1; index >= 0; index-- ){
		char c;
		for( c = s[index]+1; c < 'a' + p; c++ ) {
			ok  = true;
			if( index >= 2 ){
				ok &= s[index-2] != c;
			}
			if( index >= 1 ){
				ok &= s[index-1] != c;
			}
			if( ok )
				break;
		}
		if( ok ){
			s[index++] = c;
			break;
		}
	}
	if( !ok || index < 0 ){
		cout << "NO" << endl;
		return 0;
	}
	for( ; index < n; index++ ){
		s[index] = 'a';
		if(index >= 2 ){
			while( s[index] == s[index-1] || s[index] == s[index-2] )
				s[index]++;
		}
		else if( index >= 1 ){
			while( s[index] == s[index-1] )
				s[index]++;
		}
	}
	cout << s << endl;
	return 0;
}

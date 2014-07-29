#include<bits/stdc++.h>

using namespace std;

int main(){
	string names[] = {"vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon"};
	int n; cin >> n;
	string str; cin >> str;
	bool ok ;
	for( int i = 0; i < 8; i++ ){
		if( names[i].size() != n )
			continue;
		ok  = true;
		for( int j = 0; j < n; j++ ){
			if( str[j] != '.' && str[j] != names[i][j] )
				ok = false;
		}
		if( ok ){
			cout << names[i] << endl;
			break;
		}
	}
	return 0;
}

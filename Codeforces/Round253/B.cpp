#include<bits/stdc++.h>

using namespace std;

int main(){
	string s;
	int k, n, ss;
	cin >> s >> k;
	ss = s.size();
	for( n = ( ss + k ) >> 1; n > 2; n-- ){
		printf("trying with %d\n", n );
		bool ok = true;
		for( int i = 0; i + n < ss; i++ ){
			ok &= s[i] == s[i+n];
			if( !ok ){
				printf( "bad at %d\n", i );
				break;
			}
		}
		if( ok )
			break;
	}
	cout << 2*n << endl;
	return 0;
}

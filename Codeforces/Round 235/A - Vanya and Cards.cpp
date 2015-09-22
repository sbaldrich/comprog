#include<bits/stdc++.h>

using namespace std;

int main(){
	
	int n, x, s = 0;
	cin >> n >> x;
	for( int i=0, y; i<n; i++ ){
		cin >> y;
		s += y;
	}
	s = abs( s );
	cout << ( s % x ? s / x + 1 : s / x ) << endl;
	return 0;
}

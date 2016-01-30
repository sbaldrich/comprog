#include<bits/stdc++.h>
#define D(x,y) cout << "[" <<  #x << ":" << x << ", " << #y << ": " << y << " ]"<< endl;
using namespace std;

int main(){
	int n, v, l, h; cin >> n;
	string s;
	char a;
	l = -2 * 1e9 , h = 2 * 1e9;
	for( int i=0; i<n; i++ ){
		cin >> s >> v >> a;
		if( a == 'Y' ){
			if( s == ">" )
				l = max( l , v+1 );
			if( s == "<" )
				h = min( h, v-1 );
			if( s == "<=" )
				h = min( v, h );
			else if( s == ">=")
				l = max( v, l );
		}
		else{
			if( s == ">" )
				h = min( v, h );
			if( s == "<" )
				l = max( v, l );
			if( s == "<=" )
				l = max( v + 1, l ) ;
			else if( s == ">=")
				h = min( h, v - 1 );
		}
	}
	if( l <= h )
		cout << l << endl;
	else cout << "Impossible" << endl;
	return 0;
}

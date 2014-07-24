#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; cin >> n;
	vector<int> v( n ), p( n );
	int s = 0;
	int l = -1, r = -1;
	for( int i = 0 ; i < n; i++ )
		cin >> v[i];
	p = v;
	sort( p.begin(), p.end() );
	if( v == p ){
		cout << "yes" << endl << "1 1" << endl;
		return 0;
	}
	bool ok = true;
	for( int i = 0; i < n && ( l == -1 || r == -1 ); i++ ){
		if( l == -1 && v[i] != p[i] )
			l = i;
		if( r == -1 && v[ n - i - 1 ] != p[ n - i - 1 ] )
			r = n - i - 1;
	}
	reverse( v.begin() + l, v.begin() + r + 1 );
	if( v == p )
		cout << "yes" << endl << ++l << " " << ++r << endl;
	else cout << "no" << endl;
	
	return 0;
}

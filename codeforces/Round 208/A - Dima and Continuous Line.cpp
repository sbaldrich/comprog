#include<bits/stdc++.h>

using namespace std;

bool test( int a, int b, int c, int d ){
	if( a > b )
		swap( a, b );
	if( c > d )
		swap( c, d );
	return ( a < c && c < b && b < d ) || ( c < a && a < d && d < b );
}

int main(){
	int n; cin >> n;
	vector<int> v(n);
	for( int i = 0; i < n; i++ )
		cin >> v[i];
	bool intersect = false;
	for( int i = 0, a, b; i < n - 2; i++ ){
		a = v[i];
		b = v[i+1];
		for( int j = i + 2, c, d; j < n - 1; j++ ){
			c = v[j];
			d = v[j+1];
			intersect |= test( a, b, c, d );
		}

	}
	cout << (intersect ? "yes" : "no") << endl;

	return 0;
}

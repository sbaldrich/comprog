#include<bits/stdc++.h>

using namespace std;

set<int> ans;

void f( int a, int b, int c, int x ){
	if( !a ){
		ans.insert( x );
		return;
	}
	f( a-1, b, c, x+b );
	f( a-1, b, c, x+c );
}

int main(){
	int t, n, a, b;
	cin >> t;
	while( t-- ){
		cin >> n >> a >> b;
		f( n-1, a, b, 0 );
		while( !ans.empty() ){
			cout << *ans.begin();
			ans.erase( ans.begin() );
			if( !ans.empty() )
				cout << " ";
		}
		cout << endl;
	}
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int main(){
	int n, x;
	cin >> n >> x;
	multiset< int > s;
	for( int i=0, x; i<n; i++ ){
		cin >> x;
		s.insert( x );
	}
	ll ans = 0L;
	for( typeof( s.begin() ) it = s.begin();  it!= s.end(); it++ ){
		ans += ( (ll) *it ) * ( ll )x;
		if( x > 1 )
			x--;
	}
	cout << ans << endl;

	return 0;
}

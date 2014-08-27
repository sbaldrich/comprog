#include<bits/stdc++.h>

using namespace std;

#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)

typedef pair<int,char> ic;
typedef long long ll;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n, k; cin >> n >> k;
	string s; cin >> s;
	map<char, int> cnt;
	for( int i = 0; i < n; i++ )
		cnt[ s[i] ]++;
	set< ic > ss;
	tr( cnt, it )
		ss.insert( ic( -( it->second ), it->first) );
	ll  ans = 0LL;
	while( !ss.empty() && k ){
		ic nxt = *ss.begin();
		nxt.first *= -1;
		ans += ( ( ll ) min( k, nxt.first ) * ( ll ) min( k, nxt.first ) );
		ss.erase( ss.begin() );
		k -= min( k, nxt.first );
	}
	cout << ans << endl;
	return 0;
}

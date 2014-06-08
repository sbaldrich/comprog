#include<bits/stdc++.h>

using namespace std;

typedef pair<int, int > ii;

int main(){
	int n, v; cin >> n >> v;
	vector<ii> fruit;
	int end = 0;
	for( int i = 0, da, fr; i < n; i++ ){
		cin >> da >> fr;
		end = max( end, da );
		fruit.push_back( ii( da, fr ) );
	}
	sort( fruit.begin(), fruit.end() );
	int ans = 0;
	for( int i=1, cap; i <= end + 1; i++ ){
		cap = v;
		for( int j=0; j < n && cap; j++ ){
			if( fruit[j].first == i - 1 || fruit[j].first == i ){
				int t = min( cap, fruit[j].second );
				ans += t;
				fruit[j].second -= t;
				cap -= t;
			}
		}
	}
	cout << ans << endl;
	return 0;
}

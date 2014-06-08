#include<bits/stdc++.h>

using namespace std;

int main(){
	
	int n,v; cin >> n >> v;
	vector<int> ans;
	for ( int i=0, k, p; i<n; i++ ){
		cin >> k;
		bool ok = false;
		for( int j = 0; j < k; j++ ){
			cin >> p;
			ok |= p < v;
		}
		if( ok ) ans.push_back( i+1 );
	}
	cout << ans.size() << endl;
	for( int i = 0; i < (int) ans.size(); i++ )
		cout << (i?" ":"") << ans[i];
	if( ans.size() ) cout << endl;
	return 0;
}

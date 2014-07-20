#include<bits/stdc++.h>

using namespace std;

int main(){
	int n, m; cin >> n >> m;
	vector<int> want(n), have( n, 0 );
	int gone = 0, ans = -1;
	for( int i = 0; i < n; i++ )
		cin >> want[i];
	while( gone < n ){
		for( int i = 0; i < n; i++ )
			if( have[i] < want[i]){
				have[i] += m;
				if( have[i] >= want[i] )
					gone++;
				if( gone == n ){
					ans = i+1;
					break;
				}
			}
	}
	cout << ans << endl;
	return 0;
}

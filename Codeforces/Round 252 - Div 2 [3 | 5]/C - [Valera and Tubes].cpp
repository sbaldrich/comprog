#include<bits/stdc++.h>

using namespace std;

typedef pair<int, int> ii;

int main(){
	int n, m, k; cin >> n >> m >> k;
	int r, c = 1, kk = n * m / k, ck = 0, cur = 0;
	vector< ii > ans[k];
	for( r = 1; r <= n; r++ ){
		if( cur < kk -1 && ck == kk ){
			ck = 0;
			cur++;
		}
		if( r & 1 ){
			c = 1;
			for( ; c <= m; c++ ){
				ans[cur].push_back( ii( r, c ) );
				ck++;
				if( cur < k -1 && ck == kk ){
					ck = 0;
					cur++;
				}
			}
		}
		else{
			c = m;
			for( ; c > 0; c--){
				ans[cur].push_back( ii( r, c ) );
				ck++;
				if( cur < k -1 && ck == kk ){
					ck = 0;
					cur++;
				}
			}
		}
	}
	for( int i=0; i<k; i++ ){
		cout << ans[i].size();
		for( int j=0; j < (int)ans[i].size(); j++ )
			cout << " " << ans[i][j].first << " " << ans[i][j].second;
		cout << endl;
	}
	return 0;
}

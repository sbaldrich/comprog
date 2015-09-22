#include<bits/stdc++.h>

using namespace std;

const int M = 110;

pair<int,int> points[M]; 
int ans[M];
int main(){
	int n, m; cin >> n >> m;
	vector<int> v( n );
	for( int i = 0; i < n; i++ )
		cin >> points[i].first, points[i].second = i;
	
	for( int i = 0, x; i < n; i++ )
		cin >> x >> x;
	
	sort( points, points + n );
	for( int i = 0; i < n; i++ )
		ans[ points[i].second ] = i & 1;
	
	for( int i = 0; i < n; i++ )
		cout <<(i?" ":"") << ans[i];
	cout << endl;
	return 0;
}

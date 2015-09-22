#include<bits/stdc++.h>

using namespace std;

int main(){
	vector<int> v;
	for( int i=0; i<5; i++ )
		v.push_back( i );
	long long g[5][5];
	for( int i=0; i<5; i++ )
		for( int j=0; j<5; j++ )
			cin >> g[i][j];
	long long  ans = -1000LL;
	do{
		long long x = 0LL;
		for( int i=0; i<5; i++ ){
			for( int j=i; j<4; j+=2 ){
				//cout << v[j] << " & " << v[j+1] << endl;
				x += g[v[j]][v[j+1]] + g[v[j+1]][v[j]];
			}
			//cout << endl;
		}
		ans = max( x, ans );
	} while( next_permutation( v.begin(), v.end() ) );
	cout << ans << endl;
	return 0;
}

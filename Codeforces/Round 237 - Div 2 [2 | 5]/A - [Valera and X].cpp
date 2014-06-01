#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; cin >> n;
	vector<string> v(n);
	for( int i=0; i<n; i++ )
		cin >> v[i];
	char x = v[0][0] , o = v[1][0];
	bool flag = true;
	for( int i = 0; i < n; i++ ){
		for( int j = 0; j < n; j++ )
			if( j == i || j == n - i - 1)
				flag &= v[i][j] == x;
			else flag &= v[i][j] == o;
	}
	flag &= x != o;
	cout << ( flag ? "YES" : "NO" ) << endl;
	return 0;
}

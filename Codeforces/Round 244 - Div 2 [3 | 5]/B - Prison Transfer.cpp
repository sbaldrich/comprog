#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,t,c,ans =0 ;
	cin >> n >> t >> c;
	vector<int> v( n );
	for( int i=0; i<n; i++ )
		cin >> v[i];
	for( int i=0,cc=0; i<n; i++ ){
		if( v[i] <= t )
			cc++;
		else{
			cc = 0;
		}
		if( cc >= c )
			ans++;
		
	}
	cout << ans << endl;
}

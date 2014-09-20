#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n,x,y; cin >> n;
	vector<int>v(n);
	cin >> x;
	for( int i = 0,xx; i < x; i++ ){
		cin >> xx;
		v[xx-1] = 1;
	}
	cin >> y;
	for( int i = 0,xx; i < y; i++ ){
		cin >> xx;
		v[xx-1] = 1;
	}
	int ans = 0;
	for( int i = 0 ; i < n; i ++ )
		ans+= v[i];
	cout << (ans == n ? "I become the guy." : "Oh, my keyboard!") << endl;

		
	return 0;
}

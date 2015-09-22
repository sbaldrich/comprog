#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,k, ans = 0; cin >> n >> k;
	for( int i = 0, x; i < n; i++ ){
		cin >> x;
		ans += x + k <= 5;	
	}
	cout << ans/3 << endl;
	return 0;	
}

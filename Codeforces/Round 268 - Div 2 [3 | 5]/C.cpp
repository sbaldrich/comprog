#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n; cin >> n;
	if( n < 4 ){
		cout << "NO" << endl;
		return 0;
	}
	cout << "YES" << endl;
	while( n > 5 ){
		cout << n << " - " << (n-1) << " = 1 " << endl;
		cout << "1 * 1 = 1" << endl;
		n -= 2;
	}
	if( n == 4 ){
		cout << "4 * 3 = 12" << endl;
		cout << "12 * 2 = 24" << endl;
		cout << "24 * 1 = 24" << endl;
	}
	if( n == 5 ){
		cout << "5 * 4 = 20" << endl;
		cout << "3 - 1 = 2" << endl;
		cout << "2 * 2 = 4" << endl;
		cout << "20 + 4 = 24" << endl;
	}
	return 0;
}

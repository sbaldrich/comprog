#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,m; cin >> n >> m;
	if( n < ( ceil( m / 2.0 ) - 1 ) || m < n - 1 )
		cout << -1 << endl;
	else{
		while( m && n ){
			if( m > n ){
				cout << 11;
				m -= 2;
			}
			else if( m > n-1 ){
				cout << 1;
				m--;
			}
			cout << 0;
			n--;
		}
		if( m == 2 )
			cout << 11;
		else if( m == 1 )
			cout << 1;
		else if( m > 2 )
			cout << "CRAP";
		cout << endl;			
	}
	return 0;
}

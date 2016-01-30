#include<bits/stdc++.h>

using namespace std;

int main(){
	int n, d; cin >> n >> d;
	int songs = 0;
	for( int i = 0, x; i < n; i++ ){
		cin >> x;
		songs += x;
	}
	if( songs + ( n - 1 ) * 10  > d ) 
		cout << -1 << endl;
	else{
		d = d - songs;
		cout << d / 5 << endl;

	}
	return 0;
}

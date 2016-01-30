#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; cin >>n;
	int p = 0,a = 0; 
	for( int i=0,x; i<n; i++ ){
		cin >> x;
		if( x < 0 ){
			if( p == 0 )
				a++;
			else
				p--;
		}
		else p += x;
	}
	cout << a << endl;
}

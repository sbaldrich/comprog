#include<bits/stdc++.h>

using namespace std;

const int M = 1e9 + 7;
int main(){
	int a,b,n; cin >> a >> b >> n;
	n--;
	int d[] = {a,b,b-a,-a,-b,a-b};
	int x = d[ n % 6 ];
	x %= M;
	if( x < 0 )
		x += M;
	cout << x << endl;
	return 0;
}

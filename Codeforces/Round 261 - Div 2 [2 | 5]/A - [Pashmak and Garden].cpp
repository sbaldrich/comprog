#include<bits/stdc++.h>

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int x1,y1,x2,y2;
	cin >> x1 >> y1 >> x2 >> y2;
	int dx = abs( x1 - x2 ), dy = abs( y1 - y2 );
	if( x1 != x2 && y1 != y2 && dx != dy )
		cout << -1 << endl;
	else if( x1 == x2 )
		cout << x1 + dy << " " << y1 << " " << x1 + dy << " " << y2 << endl;
	else if( y1 == y2 )
		cout << x1 << " " << y1 + dx << " " << x2 << " " << y1 + dx << endl;
	else 
		cout << x1 << " " << y2 << " " << x2 << " " << y1 << endl;
	return 0;
}

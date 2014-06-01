#include<bits/stdc++.h>

#define DD( x, y ) cout << #x << ": " << x << " " << #y << ": " << y << endl;
using namespace std;


int main(){
	double a, d;
	int n;
	cin >> a >> d >> n;
	for( int i=1; i<=n; i++ ){
		double pos = fmod( i*d, 4*a );
		if( pos < a )
			printf( "%.4lf %.4lf", pos, 0.0 );
		else if( pos < 2*a )
			printf( "%.4lf %.4lf", a, pos - a );
		else if( pos < 3*a )
			printf( "%.4lf %.4lf", 3*a - pos, a );
		else printf("%.4lf %.4lf", 0.0, 4*a - pos );
		puts("");
	}
	return 0;
}


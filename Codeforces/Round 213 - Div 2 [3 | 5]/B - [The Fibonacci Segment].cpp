#include<bits/stdc++.h>

using namespace std;

#define max(a,b) (a)>(b)?(a):(b)

int main(){
	int n; cin >> n;
	vector<int> v( n );
	for( int i=0; i<n; i++ )
		cin >> v[ i ];
	if( n <= 2 )
		cout << n << endl;
	else{
		int best = 0, x=0;
		for( int i=2; i<n; i++ ){
			if( v[i-2] + v[i-1] == v[i] ){
				x++;
			}
			else{
				best = max( best, x );
				x = 0;
			}
		}
		cout << ( max( best, x ) )+ 2 << endl;	
	}
}


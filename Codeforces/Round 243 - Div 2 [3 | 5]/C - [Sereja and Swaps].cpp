#include<bits/stdc++.h>

using namespace std;

int solve( const int &, const int & );
int a[210], n, k;

int main(){
	cin >> n >> k;
	for( int i=0; i<n; i++ )
		cin >> a[i];
	int ans = INT_MIN;
	for( int from = 0; from < n; from++ )
		for( int to = from+1; to <= n; to++ )
			ans = max( ans, solve( from, to ) );
	cout << ans << endl;
	return 0;
}

int solve( const int &from, const int &to ){
	priority_queue< int > in , out;
	int sum = 0;
	for( int i=0; i <= n; i++ )
		if( from <= i && i<= to )
			sum += a[i], in.push( -1*a[i] );
		else
			out.push( a[i] );
	for( int i=0; i<k; i++ ){
		if( in.empty() || out.empty() ) 
			break;
		int ii = -1 * in.top();
		int oo = out.top();
		in.pop(), out.pop();
		if( oo > ii )
			sum += oo - ii; 
	}
	return sum;
} 

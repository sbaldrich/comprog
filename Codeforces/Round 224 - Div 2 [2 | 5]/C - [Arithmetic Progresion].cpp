#include<bits/stdc++.h>

using namespace std;

int main(){
	int n, a[100010];
	scanf("%d" , &n);
	for( int i=0; i<n; i++ )
		scanf("%d" , &a[i] );
	sort( a, a+n );
	if( n == 1 ){
		puts("-1");
		return 0;
	}
	
	if( a[0] == a[n-1] ){
		printf( "1\n%d\n", a[0] );
		return 0;
	}
	
	if( n == 2 ){
		int d = a[1] - a[0];
		if( d & 1 )
			printf("2\n%d %d\n", a[0] - d, a[1] + d); 
		else
			printf("3\n%d %d %d\n", a[0] - d, a[0] + d/2, a[1] + d); 
		return 0;
	}
	
	
	set<int> diff;
	for ( int i = 1; i < n; i++ ) {
		diff.insert( a[i] - a[i-1] );
		if( diff.size() > 2 )
			break;
	}
	if( diff.size() == 1 ){
		int d = *diff.begin();
		printf( "2\n%d %d\n" , a[0] - d, a[n-1] + d );
	}
	else if( diff.size() == 2 ){
		int d1 = *diff.begin(), d2 = *diff.rbegin(), q = 0, ans;
		if( 2*d1 != d2 ){
			puts("0");
			return 0;
		}
		for( int i=1; i<n; i++ ){
			if( (a[i] - a[i-1]) == d2 ){
				ans = a[i-1] + d1;
				q++;
				if( q > 1 )
					break;
			}
		}
		if( q > 1 )
			puts("0");
		else printf("1\n%d\n", ans);
	}
	else puts("0");
}

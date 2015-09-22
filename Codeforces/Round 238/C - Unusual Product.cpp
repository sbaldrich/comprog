#include<bits/stdc++.h>

using namespace std;

int M[1010];
int main(){
	int n,q,x,s=0; 
	scanf("%d", &n);
	for( int i=0,x; i<n; i++ )
		for( int j=0; j<n; j++ ){
			scanf("%d", &x );
			if( i == j ){
				s += x;
				M[i] = x;
			}
		}
	scanf("%d", &q);
	while( q-- ){
		scanf("%d", &x);
		if( x < 3 ){
			scanf("%d", &x);
			--x;
			if( M[x] )
				s -= 1;
			else 
				s += 1;
			M[x] = 1 - M[x];
		}
		else{
			printf("%d", s % 2);
		}
	}
	puts("");	
	return 0;
}

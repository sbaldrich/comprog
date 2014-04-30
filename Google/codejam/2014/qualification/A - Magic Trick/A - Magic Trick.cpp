#include<bits/stdc++.h>

using namespace std;

int main(){
	int T, x, y;
	cin >> T;
	for( int caze=1; caze<=T; caze++ ){
		vector<bool> v( 17, false );
		cin >> x;
		--x;
		for( int i=0; i<4; i++ ){
			for( int j=0; j<4; j++ ){
				cin >> y;
				if( i == x )
					v[ y ] = true;
			}
		}
		cin >> x;
		--x;
		int ans = -1;
		bool flag = false;
		for( int i=0; i<4; i++ ){
			for( int j=0; j<4; j++ ){
				cin >> y;
				if( i == x && v[ y ] ){
					if ( ans == -1 )
						ans = y;
					else flag = true;
				}
			}
		}

		printf("Case #%d: ", caze);
		if( flag )
			puts("Bad magician!");
		else if( ans == -1 )
			puts("Volunteer cheated!");
		else printf("%d\n", ans);
	}
	
	return 0;
}

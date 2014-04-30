#include<bits/stdc++.h>

using namespace std;

int M[110][110];
int main(){
	int r, c;
	cin >> r >> c;
	for( int i=0; i<r; i++ )
		for( int j=0; j<c; j++ )
			cin >> M[i][j];
	if( r & 1 )
		cout << r << endl;
	else{
		int l = r;
		bool ok = true;
		while( l % 2 == 0 && ok ){
			for( int i=0; ok && i<l; i++ )
				for( int j=0; j<c ; j++ )
					if( M[i][j] != M[l-1-i][j] ){
						ok = false;
						break;
					}
			if( ok )
				l/=2;
		}
		cout << l << endl;
	}

	return 0;
}

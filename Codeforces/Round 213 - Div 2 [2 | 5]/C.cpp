#include<bits/stdc++.h>

using namespace std;

const int M = 4010;
int matrix[M][M];

int main(){
	int a;
	string s;
	cin >> a >> s;
	for( int i=0; i<(int)s.size(); i++ )
		for( int j=0; j<(int)s.size(); j++ )
			matrix[i][j] = ( s[i] - '0' ) * ( s[j] - '0' );

	for( int i=0; i<(int)s.size(); i++ ){
		for( int j=0; j<(int)s.size(); j++ )
			cout << setw(3) << matrix[i][j];
		cout << endl;
	}


	return 0;
}

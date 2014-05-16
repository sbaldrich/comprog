#include<bits/stdc++.h>

using namespace std;

const int M = 1e5 + 10;

int main(){
	int n; cin >> n; 
	int chome[M] = {0}, away[M];
	for( int i = 0, ho; i < n; i++ ){
		cin >> ho >> away[i];
		chome[ ho ]++;
	}
	for( int i = 0; i < n; i++ )
		cout <<  n - 1 + chome[ away[i] ] << " " << n - 1 - chome[ away[i] ] << endl;
	return 0;
}

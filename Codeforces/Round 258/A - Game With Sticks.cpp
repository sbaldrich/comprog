#include<bits/stdc++.h>

using namespace std;

int main(){
	int n,m; cin >> n >> m;
	cout <<  ( min( n, m ) % 2 ? "Akshat" : "Malvika" ) << endl; 	
	return 0;
}

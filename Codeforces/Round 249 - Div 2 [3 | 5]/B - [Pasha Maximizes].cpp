#include<bits/stdc++.h>

using namespace std;

int main(){
	string str;
	int k; 
	cin >> str >> k;
	int n = str.size(), best;
	bool go;
	for( int i=0,j; i<n && k  ;i++ ){
		if( str[i] == '9' )
			continue;
		go = false;
		best = i;
		for( j=i+1; j < n && j <= i + k; j++ )
			if( str[j] > str[best] && j - i <= k)
				best = j;
		//cout << "best is " << str[best] << endl;
		while( best > i ){
			swap( str[best], str[best-1] );
			best--;
			k--;
		}
	}
	cout << str << endl;
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; cin >> n;
	string s,t;
	for( int i = 0; i < n; i++ ){
		cin >> t;
		s+= ( i == 0? "<3":"") + t + "<3";
	}
	cin >> t;
	int si, ti;
	si = ti = 0;
	while( si < s.size() && ti < t.size() ){
		if( s[si] == t[ti] )
			si++, ti++;
		else ti++;
	}
	cout << ( si == s.size() ? "yes" :"no" ) << endl;
}

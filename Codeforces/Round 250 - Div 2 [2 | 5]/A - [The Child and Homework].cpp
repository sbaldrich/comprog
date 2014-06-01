#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> ii;

int main(){
	string s;
	int n = 4;
	vector< ii > v( n );
	for( int i = 0; i < n; i++ ){
		cin >> s;
		v[i] = ii( s.size() - 2 , i );
	}
	sort( v.begin(), v.end() );
	bool lo, hi;
	lo = 2*v[0].first <= v[1].first  && v[0].first != v[1].first;
	hi = v[3].first >= 2*v[2].first && v[3].first != v[2].first;
	if( lo && !hi )
		cout << (char)( 'A' + v[0].second ) << endl;
	else if( !lo && hi )
		cout << (char)( 'A' + v[3].second ) << endl;
	else cout << 'C' << endl; 
	return 0;
}

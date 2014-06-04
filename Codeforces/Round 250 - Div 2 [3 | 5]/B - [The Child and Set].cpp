#include<bits/stdc++.h>

using namespace std;

int lb( int x ){
	return 1 << __builtin_ctz( x );
}

int main(){
	int sum, limit, odd;
	cin >> sum >> limit;
	odd = limit / 2 + ( limit & 1 );
	limit -= ( limit & 1 );
	vector<int> ans;
	for( int i = limit; i > 0 && sum > odd; i -= 2 ){
		ans.push_back( i );
		sum -= lb(i);
	}
	if( sum > odd ){
		cout << "-1" << endl;
		return 0;
	}
	for( int i=1; sum; i+=2 ){
		sum--;
		ans.push_back( i );
	}
	cout << ans.size() << endl;
	for( int i=0; i< (int) ans.size(); i++ )
		cout << (i?" ":"") << ans[i];
	cout << endl;
}

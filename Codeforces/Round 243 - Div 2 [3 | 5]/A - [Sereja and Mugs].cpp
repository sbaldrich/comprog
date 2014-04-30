#include<bits/stdc++.h>

using namespace std;

int main(){
	int n, s, ss = 0;
	cin >> n  >> s;
	vector<int> v(n);
	for( int i=0,x; i < n; i++ )
		cin >> v[i]; 
	sort(v.begin(), v.end());
	for( int i=0; i<n-1; i++ )
		ss+=v[i];
	if( ss <= s )
		cout << "YES";
	else cout << "NO";
	cout << endl;
	return 0;
}

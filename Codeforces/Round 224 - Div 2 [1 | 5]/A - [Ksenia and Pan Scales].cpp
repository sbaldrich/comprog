#include<bits/stdc++.h>

using namespace std;

int main(){
	string s,t;
	cin >> s >> t;
	int n = s.size(), m = t.size(), l = s.find('|'), r = s.size() - l - 1 , d = abs(l-r);
	if( d > m || (m - d) % 2)
		cout << "Impossible" << endl;
	else if( l < r )
		cout << t.substr(0 , d + (m-d)/2) << s << t.substr( d + (m-d)/2 ) << endl;
	else
		cout << t.substr(0 , (m - d)/2)  << s << t.substr( (m-d)/2 ) << endl;
	return 0;
}




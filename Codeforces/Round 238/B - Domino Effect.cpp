#include<bits/stdc++.h>

using namespace std;

const bool debug = true;

template<class T>
inline ostream& operator<<(ostream& out, vector<T> v){
	out << "[";
	int i,n = v.size();
	for(i=0; i<n; i++)
		out << " " << v[i];
	return out << " ]";
}

int main(){
	int n;
	string s;
	cin >> n >> s;
	vector<int> l(n), r(n);
	for( int i=0; i<n; i++ )
		if( s[i] == 'R' )
			for( int j=i,x=1; j<n; j++,x++ ){
				r[j] = x;
				if( s[j] == 'L' )
					break;
			}
	for( int i=0; i<n; i++ )
		if( s[i] == 'L' )
			for( int j=i,x=1; j>=0; j--,x++ ){
				l[j] = x;
				if( s[j] == 'R' )
					break;
			}
	int ans = 0;
	for( int i=0; i<n; i++ )
		ans += l[i] == r[i];
	cout << ans << endl;
}

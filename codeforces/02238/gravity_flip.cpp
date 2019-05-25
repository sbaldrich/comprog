#include<bits/stdc++.h>

using namespace std;

template<class T>
inline ostream& operator<<(ostream& out, vector<T> v){
	int i,n = v.size();
	out << v[0];
	for(i=1; i<n; i++)
		out << " " << v[i];
	return out;
}

int main(){
	int n; cin >> n;
	vector<int> v( n );
	for( int i=0; i<n; i++ )
		cin >> v[i];
	sort( v.begin(), v.end() );
	cout << v << endl;
}

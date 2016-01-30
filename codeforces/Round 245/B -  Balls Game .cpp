#include<bits/stdc++.h>

using namespace std;

ostream& operator<<( ostream &o, const vector<int> &v ){
	o << "[ "; 
	for( int i=0; i < (int)v.size() ; i++ )
		o << v[i]<< " ";
	return o << "]";
}

int f( vector<int> v, int pos, int ball){
	v.insert( v.begin() + pos, ball );
	int destroy = true, n = v.size();
	while( destroy ){
		destroy = false;
		for( int i=0; i< (int) v.size()-2; i++ ){
			if( v[i] == v[i+1] && v[i] == v[i+2] ){
				destroy = true;
				int xx = v[i];
				typeof ( v.begin() ) it = v.begin() + i;
				while( it != v.end() && *it == xx )
					v.erase( it );
			}
		}
	}
	return v.size();
}

int main(){
	int n,k,x;
	cin >> n >> k >> x;
	vector<int> v(n);
	for( int i=0; i<n; i++ )
		cin >> v[i];
	int ans = INT_MIN;
	for( int i=0; i<n; i++ )
		ans = max( ans, n - f( v, i, x) );
	cout << max( ans, 0 ) << endl;
	return 0;
}

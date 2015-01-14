#include<bits/stdc++.h>

using namespace std;

#define D(x) cout << "[ " << #x << " => " << x << " ]" << endl;
#define DD(x,y) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << " ]" << endl;
#define DDD(x,y,z) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << ", " << #z << " => " << z << " ]" << endl;
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

template<class T>
inline ostream& operator<<(ostream& out, vector<T> v){
	out << "[";
	int i,n = v.size();
	for(i=0; i<n; i++)
		out << " " << v[i];
	return out << " ]";
}

template<class S, class T>
inline ostream& operator<<(ostream& out, pair<S,T> pp){
	return out << "{ " << pp.first << ", " << pp.second << " }";
}

using namespace std;

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n,x; cin >> n;
	vector< vector<int> > v( 3, vector<int>() );
	for( int i = 0; i < n, cin >> x; i++ )
		v[x-1].push_back(i+1);
	n = min( min( v[0].size(), v[1].size() ), v[2].size() );
	cout << n << endl;
	while( n-- ){
		for( int i = 2; i >= 0; i-- ){
			cout << v[i][n] << ( i ? ' ' : '\n' ); 
		}
	}
	return 0;
}

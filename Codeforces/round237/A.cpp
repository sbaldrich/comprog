#include<bits/stdc++.h>

using namespace std;

const bool debug = false;

#define D(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define DD(x,y) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << " ]" << endl;
#define DDD(x,y,z) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << ", " << #z << " => " << z << " ]" << endl;
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

int main(){
	if(debug)
		freopen("aa.in", "r", stdin);
	int n; cin >> n;
	vector<string> m(n);
	for( int i=0; i<n; i++)
		cin >> m[i];
	n--;
	bool ok = true;
	char xx = m[0][1], x = m[0][0];
	for( int i=0; i<=n && ok; i++){
		ok &= (m[i][i] == x) && (m[i][n-i] == x);
	}
	for( int i=0; i<=n; i++ ){
		for( int j=0; j<=n; j++ ){
			if( j == i || j == n-i )
				continue;
			ok &= m[i][j] == xx;
		}
	}	
	ok &= x != xx;
	cout << (ok?"YES":"NO") << endl;	
	return 0;
}



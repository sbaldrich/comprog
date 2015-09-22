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

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int p,n; cin >> p >> n;
	set<int> s;
	for( int i = 1,x; i <= n; i++ ){
		cin >> x; x %= p;
		if( s.find(x) != s.end() ){
			cout << i << endl; 
			return 0;
		}
		s.insert(x);
	}
	cout << -1 << endl;
	return 0;
}

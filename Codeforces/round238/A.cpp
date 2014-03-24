#include<bits/stdc++.h>

using namespace std;

const bool debug = false;
 Toogle paste mode with F2
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
	int n;cin >> n;
	vector<int> v(n);
	for( int i=0; i<n ; i++ )
		cin >> v[i];
	for( int i=n-2; i>=0; i-- ){
		while( v[i] > v[i+1] ){
			int p = i;
			for( int j=i; j<n; j++ )
				if( v[i] > v[j])
					p++;
			v[i]--,v[p]++;
		}
	}
	for( int i=0; i<n; i++ )
		cout << (i?" ":"") << v[i];
	cout << endl;
	return 0;
}

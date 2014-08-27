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

typedef long long ll;

int main(){
    ios :: sync_with_stdio( 0 );
    cin.tie( 0 );
    int n; cin >> n;
    vector<ll> v( n ), ss( n );
    for( int i = 0; i < n; i++ )
        cin >> v[i];
    sort( all(v), greater<ll>());
    ss[0] = v[ 0 ];
    for( int i = 1; i < n; i++ )
        ss[ i ] = ss[ i-1 ] + v[i];
    ll ans = v[ 0 ];
    for( int i = n-1; i > 0; i-- )
        ans += ss[ i ] + v[ i ];
    cout << ans << endl;    
    return 0;
}

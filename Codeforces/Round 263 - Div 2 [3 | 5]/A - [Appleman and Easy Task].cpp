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

const int MM = 110;

char M[MM][MM];

int dr[] = {0, -1, 0, 1};
int dc[] = {-1,0,1,0};

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	int n; cin >> n;
	for( int i = 1; i <= n; i++ )
		for( int j = 1; j <= n; j++ )
			cin >> M[i][j];
	bool ok = true;
	for( int i = 1; i <= n; i++ )
		for( int j = 1,x; j <= n; j++ ){
			x = 0;
			for( int k = 0; k < 4; k++ )
				if( M[i + dr[k]][j + dc[k]] == 'o' )
					x++;
			ok &= ( x % 2 == 0 );
		}
	cout << ( ok? "YES" : "NO" ) << endl;
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

const bool debug = true;

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
	string s; cin >> s;
	vector<int> l(n), r(n);
	for( int i=0; i<n; i++){
		if( s[i] == 'L' ){
			l[i] = 1;	
			for( int j=i-1; j>=0; j-- ){
				l[j] = l[j+1]+1;
				if( s[j] != '.' )
					break;
			}
		}
	}
	for( int i=0; i<n; i++){
		if( s[i] == 'R' ){
			r[i] = 1;	
			for( int j=i+1; j<n; j++ ){
				r[j] = r[j-1]+1;
				if( s[j] != '.' )
					break;
			}
		}
	}
	int ans = 0;
	for( int i=0; i<n; i++ ){
		if( l[i] == r[i] && l[i] == 0 )
			ans++;
		else if( l[i] == r[i + l[i] - 1]  && (l[i] % 2) )
			ans++;
	} 
	D(l)
	D(r)
	cout << ans << endl;
	return 0;
}



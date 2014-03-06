#include<bits/stdc++.h>

using namespace std;

const bool debug = true;

#define D(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define DD(x,y) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << " ]" << endl;
#define DDD(x,y,z) if(debug) cout << "[ " << #x << " => " << x << ", " << #y << " => " << y << ", " << #z << " => " << z << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
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
	vector< vector<int> > dp(n , vector<int> (n) );
	for( int i = 0; i < n; i++ ) 
		cin >> v[i];
	for( int i = 0; i < n; i++ ){
		for(int j=i-1;j >= 0;j--)
			dp[i][j] = dp[i][j+1] + (v[j] > v[i]);
		for(int j=i+1; j<n; j++)
			dp[i][j] = dp[i][j-1] + (v[j] > v[i]);
	}
	D(v)
	for( int i=0; i<n; i++)
		D(dp[i])
	int best, q=0, actual=0;
	for(int i=0; i<n; i++)
		for(int j=i+1; j<n; j++)
			actual+=v[i] > v[j];
	best = actual;	
	D(actual)
	for(int i=0; i<n; i++)
		for(int j=i+1,x; j<n; j++)
			if(v[i] > v[j]){
				x = actual - 2 * (dp[j][i] - dp[i][j]) + 1;
				if(x < best){
					best = x;
					q = 1;
				}
				else if(x == best){
					q++;
				}
			}
	cout << best << " " << q << endl;
	return 0;
}

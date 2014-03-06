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
	int n; cin >>n;
	vector<int> v(101);
	for(int i,l,r; i<n;i++){
		cin >> l >> r;
		if(!i){
			for(int j=l; j<r; j++)
				v[j] = 1;
		}
		else{
			for(int j=l; j<r; j++)
				v[j] = 0;
		}
		D(v)
	}
	int ans = 0;
	for(int i=0;i<=100;i++)
		ans+= v[i];
	cout << ans << endl;
	return 0;
}

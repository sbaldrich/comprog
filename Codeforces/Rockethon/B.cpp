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
	string s;cin >> s;
	int n = s.size(),p,ans = 1,cur;
	for(int i=0,q;i<n;i++){
		p = i;
		q = 0;
		cur = 1;
		for(int k=i+1;k<n;k++){
			DDD(s[k], s[p],q)
			D(p)
			if(s[k] == s[p]){
				if(q%2){
					q++;
					continue;
				}
				cur++;
				q = 0;
				p = k;
			}
			else q++;
		}
		ans = max(cur,ans);
		D(ans)
	}
		
	
	cout << ans << endl;
	return 0;
}

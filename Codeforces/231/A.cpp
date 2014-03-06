#include<bits/stdc++.h>

using namespace std;

const bool debug = false;

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
	string a, b, c;
	getline(cin,a,'+');
	getline(cin,b,'=');
	getline(cin,c);
	int aa = a.size(), bb = b.size(), cc = c.size();
	if( aa + bb == cc ) 
		cout << a << "+" << b << "=" << c << endl;
	else if(aa + 1 + bb == cc - 1)
		cout << a << "|+" << b << "=" << c.substr(0,cc-1) << endl;
	else if(aa - 1 + bb == cc + 1){
		if(aa == 1)
			cout << a << "+" << b.substr(0,bb-1) << "=" << c << "|" << endl;
		else
			cout << a.substr(0,aa-1) << "+" << b << "=" << c << "|" << endl;
	}
	else
		cout << "Impossible" << endl;
	return 0;
}

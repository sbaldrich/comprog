#include<bits/stdc++.h>

using namespace std;

const bool debug = false;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int main(){
	if(debug)
		freopen("aa.in", "r", stdin);
	vector<char> a,b;
	string x,y,l,r;
	int m,n,nn,i=0;
	cin >> x >> y;
	nn = y.size();
	m = x.find('|');
	l = x.substr(0,m), r = x.substr(m+1,x.size()); 
	m = l.size(), n = r.size();
	while(m < n && i < nn){
		l+=y[i++];
		m++;
	}
	while(m > n && i < nn){
		r+=y[i++];
		n++;
	}
	while(i < nn){
		l+=y[i++];
		m++;
		if(i == nn)
			break;
		r+=y[i++];
		n++;
	}
	if(m == n)
		cout << l << "|" << r << endl;
	else cout << "Impossible" << endl;
	return 0;
}




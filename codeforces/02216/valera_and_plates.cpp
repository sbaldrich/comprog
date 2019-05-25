#include<bits/stdc++.h>

using namespace std;

const bool debug = true;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

int main(){
	if(debug){
		freopen("aa.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}
	int m, n, k, a = 0;
	cin >> n >> m >> k;
	for(int i=0,x;i<n;i++){
		cin >> x;
		if(x == 2){
			if(k)
				k--;
			else if(m)
				m--;
			else a++;
		}
		else{
			if(m)
				m--;
			else a++;
		}
	}
	cout << a << endl;
	return 0;
}

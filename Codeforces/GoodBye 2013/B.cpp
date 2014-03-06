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
		freopen("bb.in", "r", stdin);
	int n;
	cin >> n;
	vector<int> a(n,0), b(n,0);
	rep(i,0,n-1)
		cin >> a[i];
	int cur = -1;
	for(int i=0;i<n;i++){
		while(b[i] != a[i]){
			cout << "P";
			b[i]++;
			if(b[i] == a[i])
				break;
			if(i == n-1)
				cout << "LR";
			else
				cout << "RL";
		}
		if(i<n-1)
			cout << "R";
	}
	cout << endl;
	return 0;
}

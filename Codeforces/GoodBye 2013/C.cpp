#include<bits/stdc++.h>

using namespace std;

const bool debug = true;
#define TRACE(x) if(debug) cout << "[ " << #x << " => " << x << " ]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 

struct user{
	int p;
	long long r;
	user(int _p, long long _r) : p(_p), r(_r) {}
};

bool _cmp(user a, user b){
	return a.r < b.r;
}

bool _cmp2(user a, user b){
	return a.p < b.p;
}

int main(){
	if(debug)
		freopen("cc.in", "r", stdin);
	int n;
	cin >> n;
	vector<user> v;
	long long r;
	for(int i=0;i<n;i++){
		cin >> r;
		v.push_back(user(i,r));
	}
	sort(all(v),_cmp);
	long long least = 0LL;
	for(int i=0;i<n;i++){
		if(least < v[i].r)
			least = v[i].r;
		else v[i].r = ++least;
	}
	sort(all(v), _cmp2);
	for(int i=0;i<n;i++)
		cout << v[i].r << (i<n-1?" ":"\n");
	return 0;
}

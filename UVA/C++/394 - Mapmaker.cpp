#include<string>
#include<map>
#include<iostream>
#include<vector>
#include<cstring>

using namespace std;

#define TRACE(x) if(debug)cout <<"[ " << #x  << " -> " << x << " ]" <<  endl
const bool debug = false;

struct array{
	int b,d,l[11], u[11], c[11];
	array(int b,int cd, int d) : b(b), d(d) {
		memset(l, 0, sizeof(int) * 11);
		memset(u, 0, sizeof(int) * 11);
		memset(c, 0, sizeof(int) * 11);
		c[0] = b; c[d] = cd;
	}
	array(){}
	void init(){
		for(int i = d-1; i>=1;i--)
			c[i] = c[i+1] * (u[i+1] - l[i+1] + 1); 
		for(int i=1;i<=d;i++)
			c[0] -= c[i]*l[i];
	}
	int calc(const vector<int> &q){
		int ans = c[0];
		for(int i=1;i<=d;i++)
			ans+=q[i-1] * c[i];
		return ans;
	}
};


int main(){
	freopen("394.in", "r", stdin);
	int n,r;
	string name;
	map<string,array> m;
	while(cin >> n >> r){
		m.clear();
		for(int i=0,b,cd,d;i<n;i++){
			cin>>name>>b>>cd>>d;
			array a = array(b,cd,d);
			for(int j=1;j<=d;j++)
				cin>>a.l[j] >> a.u[j];
			m[name] = a;
			m[name].init();
		}
		for(int i=0; i < r; i++){
			cin>>name;
			TRACE(name);
			array &a = m[name];
			vector<int> q(a.d,0);
			for(int j=0;j<a.d;j++)
				cin>>q[j];
			cout << name << "[";
			for(int j=0;j<a.d;j++)
				cout << (j?", ":"") << q[j];
			cout << "] = " << a.calc(q) << endl;
		}

	}
	return 0;
}

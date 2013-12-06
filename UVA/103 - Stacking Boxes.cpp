#include<algorithm>
#include<iostream>
#include<sstream>
#include<iomanip>
#include<cstring>
#include<set>
#include<queue>
#include<utility>
#include<map>
#include<string>
#include<cstdio>
#include<cmath>
#include<vector>
#include<bitset>
#include<stack>

using namespace std;

const bool debug = true;
#define TRACE(x) cout << "[ " << #x << " => " << x << "]" << endl;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define all(c) c.begin(),c.end()
#define tr(c, it) for(typeof(c.begin()) it = c.begin(); it != c.end(); it++)
#define max(a,b) (a) > (b) ? (a) : (b) 
#define min(a,b) (a) < (b) ? (a) : (b) 



struct box{
	int id;
	vector<int> d;
	box(int id, int n){
		this->id = id;
		d.resize(n,0);
	}
	box(){}
	void s(){
		sort(d.begin(),d.end());
	}

};

bool _cmp(const box &a, const box &b){
	for(int i=0;i< a.d.size();i++)
			if(a.d[i] >= b.d[i])
				return false;
		return true;
}

void output(int i, const vector< box > &v, const vector<int> p){
	if(p[i] == -1)
		cout << v[i].id;
	else{
		output(p[i], v, p);
		cout << " " << v[i].id;
	}
		
}

int main(){
	if(debug){
		freopen("aa.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}

	int k,n,best;
	while(cin >> k >> n){
		best = 0;
		vector< box > v;
		vector< int > p(k,-1), dp(k,1);
		for(int i=0, y; i<k; i++){
			box b(i+1,n);
			for(int j=0, x; j<n; j++)
				cin >> b.d[j];
			b.s();	
			v.push_back(b);
		}
		sort(all(v), _cmp);
		//for(int i=0; i<k; i++){
		//	cout << v[i].id << " -> [ ";
		//	for(int j=0; j<n; j++)
		//		cout << v[i].d[j] << " ";
		//	cout <<  "]" << endl;
		//}
		for(int i=1; i<k ;i++){
			for(int j=0; j<i; j++)
				if(_cmp(v[j], v[i])){
					if(dp[i] < dp[j] + 1){
						dp[i] = dp[j] + 1;
						p[i] = j;
						if(dp[i] > best){
							best = i;
						}
					}
				}
		}
		cout << dp[best] << endl;output(best,v,p);cout << endl;
	}
	return 0;
}

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


int main(){
	if(debug){
		freopen("aa.in", "r", stdin);
		//freopen("aa.out", "w", stdout);
	}
	int n,k;
	cin >> n >> k;
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(i == j)
				cout << k;
			else 
				cout << 0;
		}
		cout << endl;
			
	}
	return 0;
}

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
	int a,b,sum=0;
	cin >> a >> b;
	while(a >= b){
		a-=b;
		sum+=b;
		++a;

	}
	sum+=a;
	cout << sum << endl;
	return 0;
}

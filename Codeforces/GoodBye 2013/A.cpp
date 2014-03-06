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
	int a,b,h=0,c=0,l=0;
	scanf("%d %d", &a, &b);
	while(1){
		h+=a;
		a+=l;
		c = a/b;
		l = a%b;
		a = c;
		if(!a)
			break;
	}
	printf("%d", h);
	return 0;
}

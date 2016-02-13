#include<iostream>
#include<vector>
#include<cstring>

using namespace std;

#define min(a,b) (a)<(b)?(a):(b)
#define abs(x) (x) > (0) ? (x) : -(x)

int main(){
	
	//freopen("a.in" , "r" , stdin);
	int m = 0 , h = 0, a,q;
	bool v[200];
	memset(v, false, sizeof(v));
	for(int i=0;h<=360;i++){
		a = abs(h - m);
		a = min(a, 360 - a);
		v[a] = true;
		if(i && (i%12 == 0)) h+=6;
		m = (m + 6) % 360;
	}
	while(cin>>q){
		cout << (v[q] ? "Y" : "N") << endl;
	}
	return 0;
}



#include<iostream>

using namespace std;

bool ok(int n){
	int a[10] = {0};
	while(n>0){
		a[n%10] ++;
		n/=10;
	}
	for(int i=0;i<10;i++)
		if(a[i] > 1)
			return false;
	return true;
}

int main(){
	int m,n;
	while(cin>>m>>n){
		int ans = 0;
		for(int i=m;i<=n;i++)
			if(ok(i))
				ans++;
		cout << ans << endl;
	}
	
	return 0;
}



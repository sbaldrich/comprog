#include<bits/stdc++.h>

using namespace std;

#define max(a,b) (a) > (b) ? (a) : (b) 

const int M = 5010, oo = 1 << 30;

struct S{
	int o,l,r,x;
	S(){}
}ops[M];

int main(){
	int n,m; cin >> n >> m;
	for(int i=0;i<m;i++){
		S &r = ops[i];
		cin >> r.o >> r.l >> r.r >> r.x;
		r.l--,r.r--;
	}
	int ans[M] = {}, touch[M] = {}, tmp[M] = {};
	for(int i=m-1;i>=0;i--){
		S &r = ops[i];
		if(r.o == 1){
			for(int j=r.l; j<=r.r; j++)
				if(touch[j])
					ans[j]-=r.x;
		}
		else{
			for(int j = r.l; j <= r.r; j++)
				if(touch[j])
					ans[j] = min(ans[j], r.x);
				else {
					touch[j] = 1;
					ans[j] = r.x;
				}
		}
	}

	for(int i=0;i<n;i++)
		tmp[i] = ans[i];
	bool flag = false;
	for(int i=0,j,t;i<m;i++){
		S &r = ops[i];
		if(r.o == 1){
			for( j = r.l; j <= r.r; j++ ){
				tmp[j] += r.x;
			}
		}
		else{
			t = -oo;
			for( j = r.l; j<= r.r; j++)
				t = max(t, tmp[j]);
			if( t != r.x ){
				flag = true;
				break;
			}
		}
	}	
	if(flag)
		cout << "NO";
	else{
		cout << "YES" << endl;
		for(int i=0; i<n; i++)
			cout << (i?" ":"") << ans[i];
	}
	cout << endl;
	return 0;
}

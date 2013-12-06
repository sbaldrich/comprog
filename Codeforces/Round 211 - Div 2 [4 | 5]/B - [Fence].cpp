#include<iostream>
#include<vector>

using namespace std;

#define min(a,b) (a) < (b) ? (a) : (b)

int main(){
	int n, k, s=0, best, ans = 1;
	cin >> n >> k;
	vector<int> h(n,0);
	for(int i=0;i<n;i++){
		cin >> h[i];
		if( i < k )
			s+=h[i];
	}
	best = s;
	for(int i=k;i<n;i++){
		s = s - h[i - k] + h[i];
		if(s < best){
			best = s;
			ans = i-k+2;
		}
	}
	cout << ans << endl;
	return 0;
}

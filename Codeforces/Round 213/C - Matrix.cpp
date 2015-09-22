#include<bits/stdc++.h>

using namespace std;

const int M = 9 * 4000;

int counts[M];
int sums[M] = {0};

typedef long long ll;

int main(){
	int a; cin >> a;
	string s; cin >> s;
	int n = s.size();
	for( int i = 0 ; i < n; i++ ){
		sums[i] = s[i] - '0';
		if( i )
			sums[i] += sums[i-1];
	}
	
	for( int i = 0; i < n; i++ ){
		int before = i == 0 ? 0 : sums[i-1];
		for( int j = i; j < n; j++ )
			counts[ sums[j] - before ]++;
			
	}
	ll ans = 0;
	if( a ){
		for( int i = 1 ; i <= M; i++ ){
			if( a % i == 0 ){
				if( a / i < M )
					ans += (ll) counts[ i ] * (ll)counts[ a / i ];
			}
		}
	}
	else{
		for(int i = 1; i < M; i++)
        	ans += (ll)counts[0] * (ll)counts[i];
        ans = 2 * ans + (ll)counts[0] * (ll)counts[0] ;
	}
	cout << ans << endl;	
	return 0;
}

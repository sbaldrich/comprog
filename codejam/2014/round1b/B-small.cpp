#include<bits/stdc++.h>

using namespace std;

int main(){
	int T; cin >> T;
	int A,B,K,ans;
	for( int caze = 1; caze <= T; caze++ ){
		cin >> A >> B >> K;
		ans = 0;
		for( int i=0; i < A; i++ )
			for( int j=0; j < B; j++ )
				if( (i & j) < K )
					ans++;
		cout << "Case #"<< caze << ": " << ans << endl;
	}
	return 0;
}

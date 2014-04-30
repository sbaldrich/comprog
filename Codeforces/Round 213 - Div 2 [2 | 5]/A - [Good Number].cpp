#include<bits/stdc++.h>

using namespace std;

bool f( int x,int k ){
    int a[10] = {};
    a[ 0 ] = x == 0;
	while( x > 0 ){
        a[ x % 10 ] = 1;
        x /= 10;
    }
    bool all = true;
    for( int i=0; i<=k; i++ )
        all &= a[i];
    return all;
}


int main(){
    int n , k, ans = 0;
    cin >> n >> k;
    for( int i=0,x; i<n; i++ ){
        cin >> x;
        if( f( x, k ) )
			ans++;
    }
    cout << ans << endl;
    return 0;
}


#include<bits/stdc++.h>

using namespace std;

#define all(c) c.begin(),c.end()

typedef long long ll;

int main(){
    ios :: sync_with_stdio( 0 );
    cin.tie( 0 );
    int n; cin >> n;
    vector<ll> v( n ), ss( n );
    for( int i = 0; i < n; i++ )
        cin >> v[i];
    sort( all(v), greater<ll>());
    ss[0] = v[ 0 ];
    for( int i = 1; i < n; i++ )
        ss[ i ] = ss[ i-1 ] + v[i];
    ll ans = v[ 0 ];
    for( int i = n-1; i > 0; i-- )
        ans += ss[ i ] + v[ i ];
    cout << ans << endl;    
    return 0;
}

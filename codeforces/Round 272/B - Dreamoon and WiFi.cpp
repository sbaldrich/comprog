#include<bits/stdc++.h>

using namespace std;

double dp[25][25];

int main(){
    ios :: sync_with_stdio( 0 );
    cin.tie( 0 );
    string t,str; cin >> t >> str;
    int x = 0,end,n = str.size();
    for( int i = 0; i < n; i++ )
        x += ( t[i] == '+' ? 1 : -1 );
    end = x + 11;
    dp[0][11] = 1.0;
    for( int i = 1; i <= n; i++ ){
        for( int j = 1; j < 24; j++ ){
            if( str[i-1] == '+' )
                dp[i][j+1] = dp[i-1][j];
            else if( str[i-1] == '-' )
                dp[i][j-1] = dp[i-1][j];
            else{
                dp[i][j-1] += dp[i-1][j] * 0.5;
                dp[i][j+1] += dp[i-1][j] * 0.5;
            }
        }
    }
    printf( "%.12f\n", dp[n][end] ); 
    return 0;
}


/**
 * source: https://www.hackerrank.com/challenges/common-child
 * tags: dp
 * 
 * The classic Longest Common Subsequence problem.
 */
#include<bits/stdc++.h>

using namespace std;

#define N 5010
#define max(x,y) x >= y ? x : y

int dp[N][N];

int main(){
    ios::sync_with_stdio(false);
    freopen("input.txt", "r", stdin);
    string s,t;
    cin >> s >> t;
    int n = (int)s.length();
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(s[i-1] == t[j-1])
                dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
        }
    }
    cout << dp[n][n] << endl;
    return 0;
}


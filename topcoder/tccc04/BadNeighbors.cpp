#include <bits/stdc++.h>

using namespace std;

int dp[50][2];

class BadNeighbors {
public:
	int maxDonations(vector <int> donations) {
		int n = donations.size();
		dp[0][0] = 0;
		dp[0][1] = donations[0];
		dp[1][0] = donations[1];
		dp[1][1] = max(donations[0], donations[1]);
		for(int i = 2; i < n; i++){
			int &money = donations[i];
			dp[i][0] = max(money + dp[i-2][0], dp[i-1][0]);
			dp[i][1] = max(money + dp[i-2][1], dp[i-1][1]);
		}
		return max(dp[n-1][0], dp[n-2][1]);
	}
};

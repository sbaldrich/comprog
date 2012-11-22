#include<iostream>
#include<string>

using namespace std;

int dp[1010][1010];
int main() {
	string a, b;
	//freopen("10405.in", "r", stdin);
	while (getline(cin,a)) {
		getline(cin,b);
		a = " " + a, b = " " + b;
		int m = a.size(), n = b.size();
		for (int i = 0; i < m; i++)
			dp[i][0] = 0;
		for (int i = 0; i < n; i++)
			dp[0][i] = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = (a[i] == b[j] ?dp[i-1][j-1] + 1 : max(dp[i - 1][j], dp[i][j - 1]));
			}
		}
		cout << dp[m-1][n-1] << endl;
	}
	return 0;
}

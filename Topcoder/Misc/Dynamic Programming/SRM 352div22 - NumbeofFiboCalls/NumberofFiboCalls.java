/*
 * Problem: SRM 352 - Div2 -2 NumberofFiboCalls
 * author: sbaldrich
 * Simple dp.
 */

public class NumberofFiboCalls {

	private int dp[][] = new int[50][2];

	public int[] fiboCallsMade(int n) {
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		return new int[]{dp[n][0],dp[n][1]};
	}

}

/*
 * UVA 512 - Dividing Coins.
 * author: sbaldrich
 * Simple DP problem, there seems to be a one-dimensional solution, but one can also reduce it
 * to a 0-1Knapsack on a Sum/2 capacity where sum is the total sum of the coins.
 * Output the total difference of sum - 2*dp[m][sum/2] and get AC. 
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void dump(int[][] matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=1;j<matrix[0].length;j++)
				System.out.printf("%d ",matrix[i][j]);
			System.out.println();
		}
		System.out.println("*");
	}
	public static void main(String[] args) throws Exception{
		//Scanner sc = new Scanner(new File("512.in"));
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0;c<cases;c++)
		{
			int m = sc.nextInt(), sum=0;
			int coins[] = new int[m+1];
			for(int i=1;i<=m;i++)
			{
				coins[i] = sc.nextInt();
				sum+=coins[i];
			}
			int K=sum/2;
			int dp[][] = new int[m+1][K+1];
			Arrays.fill(dp[0],0);
			//System.out.println("INITIAL: " + (m+1) + " , " + K);
			//dump(dp);
			for(int i=1;i<=m;i++)
			{
			//	System.out.println("Cheking coin " + i);
				for(int j=1;j<=K;j++)
				{
					if(j>=coins[i])
						dp[i][j] = Math.max(dp[i-1][j], coins[i] + dp[i-1][j-coins[i]]);
					else
						dp[i][j] = dp[i-1][j];
				}
				//dump(dp);
			}
			System.out.println(sum - 2*dp[m][K]);
		}
	}

}

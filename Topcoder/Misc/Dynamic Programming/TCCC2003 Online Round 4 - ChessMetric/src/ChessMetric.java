import java.util.Arrays;

/*
 * TCCC2003 ChessMetric
 * author: sbaldrich
 * Since we know where we start and where we end, and also we know how many movements we must use,
 * keep a 3 dimensional array like [movesLeft][r][c]=number of ways to get to this state. 
 * In each iteration ( from numMoves down to 0 ) move to every possible position accumulating on 
 * each destination the total so far. The answer lies on dp[0][end[0]][end[1]]  
 */

public class ChessMetric {

	int dr[] = {-2,-2,-1,-1,-1,-1,-1,0,0,1,1,1,1,1,2,2};
	int dc[] = {-1,1,-2,-1,0,1,2,-1,1,-2,-1,0,1,2,-1,1};
	
	public static boolean ok(int r, int c, int s)
	{
		return (r<s && r>=0 && c<s && c>=0);
	}
	
	public static void dump(long[][] matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				if(matrix[i][j]==-1)
					System.out.printf("%5s" , ".");
				else
					System.out.printf("%5d" , matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public long howMany(int size, int[] start, int[] end, int numMoves) {
		long[][][] dp = new long[numMoves+1][size][size];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				Arrays.fill(dp[i][j], -1);
		for(int l=0;l<16;l++)
		{
			if(ok(start[0]+dr[l],start[1]+dc[l],size))
			{								
				dp[numMoves-1][start[0]+dr[l]][start[1]+dc[l]]=1;
			}
		}
		for (int i = numMoves - 2; i >= 0; i--) {
			for (int j = 0; j < size; j++)
				for (int k = 0; k < size; k++) {
					if(dp[i+1][j][k]!=-1)
					{
						for(int l=0;l<16;l++)
						{
							if(ok(j+dr[l],k+dc[l],size))
							{								
								if(dp[i][j+dr[l]][k+dc[l]] == -1)
									dp[i][j+dr[l]][k+dc[l]] = 0;
								dp[i][j+dr[l]][k+dc[l]]+=dp[i+1][j][k];
							}
						}
					}
				}
		}
		return Math.max(0, dp[0][end[0]][end[1]]);
	}
	
}

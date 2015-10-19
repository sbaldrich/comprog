import java.util.*;

public class AvoidRoads{
	public long numWays(int width, int height, String[] bad){
		width++;
		height++;
		Set<String> block = new HashSet<>();
		for( String s : bad )
			block.add( s );
		long[][] dp = new long[height+1][width+1];
		dp[1][1] = 1;
		for( int i = 1; i <= height; i++ )
			for( int j = 1; j <= width; j++ ){
				if( can( i-1, j, i , j, block ) ) dp[i][j] += dp[i-1][j];
				if( can( i, j-1, i, j, block ) ) dp[i][j] += dp[i][j-1];
			}

		return dp[height][width];
	}

	boolean can( int i, int j, int k, int l, Set<String> block ){
		--i;--j;--k;--l;
		String s1 = String.format("%d %d %d %d", j, i, l, k), s2 = String.format( "%d %d %d %d", l, k, j, i);
        return !( block.contains( s1 ) || block.contains( s2 ) );
	}
}

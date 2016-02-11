import java.util.*;
import static java.lang.Math.min;
public class StripePainter{

    char[] g;
    int memo[][][];

    int f(int l, int r, char c){ // Min. number of strokes needed to paint tiles [i,j)
                                 // with the desired color given that the current color is c
    	if( l >= r ) return 0;
    	if( memo[l][r][c] > 0 )
    		return memo[l][r][c];
    	if( g[l] == c ) return memo[l][r][c] = f(l+1, r, c);
    	if( g[r-1] == c ) return memo[l][r][c] = f(l, r-1, c);
    	int ans = 777;
    	for( int i= l + 1; i <= r; i++ )
    		ans = min( ans, 1 + f( l, i, g[l] ) + f( i, r, c ) );
    	return memo[l][r][c] = ans;
    }

    public int minStrokes(String stripes){
        memo = new int[51][51][100];
        g = stripes.toCharArray();
        return f(0, stripes.length(), '?');
    }
}

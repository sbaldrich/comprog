import java.util.*;
import static java.lang.Math.min;
public class StripePainter{

    char[] goal;
    int memo[][][];

    int f(int st, int sz, char color){
        if(sz <= 1) return sz == 0 || color == goal[st] ? 0 : 1;
        if(memo[st][sz][color] > 0 )
            return memo[st][sz][color];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= sz; i++)
            ans = min( ans, 1 + f( st + 1, i - 1, goal[st] ) + f( st + i, sz - i, color ) );
        return memo[st][sz][color] = ans;
    }
    public int minStrokes(String stripes){
        memo = new int[51][51][91];
        goal = stripes.toCharArray();
        return f(0, stripes.length(), '?');
    }

    public static void main(String args[]){
        System.out.println(new StripePainter().minStrokes("RGBGR"));
        System.out.println(new StripePainter().minStrokes("RGR"));
    }
}

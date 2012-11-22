import java.util.HashMap;
import java.util.Map;
/*
 * Problem: ShorterSuperSum
 * Source: Topcoder SRM 467
 * author: sbaldrich
 * 
 * Simple memoization gives us the answer.
 */

public class ShorterSuperSum {
	
	Map<Integer[],Integer> memo = new HashMap<Integer[],Integer>();
	public int f(int k,int n)
	{
		if(k == 0)
			return n;
		Integer x[] = new Integer[]{n,k};
		if(memo.containsKey(x))
			return memo.get(x);
		else
		{
			int ans = 0;
			for(int i=1;i<=n;i++)
				ans+=f(k-1,i);
			memo.put(x,ans);
			return ans;
		}
	}
	public int calculate(int k, int n)
	{
		return f(k,n);
	}
	
}

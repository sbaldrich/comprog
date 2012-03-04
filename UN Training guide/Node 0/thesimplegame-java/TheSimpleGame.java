public class TheSimpleGame {

	private static int min(int ... a)
	{
		int ans = Integer.MAX_VALUE;
		for(int x : a)
			ans = Math.min(ans, Math.abs(x));
		return ans;
	}
	private static int d(int x1, int y1, int x2, int y2)
	{
		return Math.abs(y2-y1) + Math.abs(x2-x1);
	}
	public int count(int n, int[] x, int[] y) {
		int ans = 0;
		for(int i=0;i<x.length;i++)
		{
			ans+=min(d(x[i],y[i],1,1) , d(x[i],y[i],n,1), 
				 d(x[i],y[i],1,n), d(x[i],y[i],n,n));
		}
			
		return ans;
	}

}

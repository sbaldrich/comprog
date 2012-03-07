public class BinaryPolynomialDivTwo {

	private static int p(int x , int p)
	{
		if(p == 0)
			return 1;
		int ans = x;
		for(int i=1;i<p;i++)
			ans*=x;
		return ans;
	}
	
	public int countRoots(int[] a) {
		int ans = 0;
		int x = 0;
		for(int i=0;i<a.length;i++)
			x+=a[i]*p(1,i);
		if(x%2 == 0)
			ans++;
		x=0;
		for(int i=0;i<a.length;i++)
			x+=a[i]*p(0,i);
		if(x%2 == 0)
			ans++;
		return ans;
	}

}

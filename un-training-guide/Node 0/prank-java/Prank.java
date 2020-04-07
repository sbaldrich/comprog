import java.util.ArrayList;

public class Prank {

	public long sq(long x)
	{
		return x*x;
	}
	public int[] realWeight(int ag) {
		int M = 50000;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		long x , y , z;
		for(long i=1;i<M; i++)
		{
			x = sq(i) + ag; 
			y = (long)Math.sqrt(x);
			if(y*y == x)
				ans.add((int)y);
		}
		int n,a[] = new int[n=ans.size()];
		for(int i =0;i<n;i++)
			a[i] = ans.get(i);
		return a;
	}

}

import java.util.HashSet;
import java.util.Set;

public class FortunateNumbers {

	public boolean f(int x)
	{
		while(x>0)
		{
			int d = x%10;
			if(d != 8 && d != 5)
				return false;
			x/=10;
		}
		return true;
	}
	public int getFortunate(int[] a, int[] b, int[] c) {
		Set<Integer> s = new HashSet<Integer>();
		int i,j,k,m=a.length, n=b.length, o=c.length;
		for(i=0;i<m;i++)
			for(j=0;j<n;j++)
				for(k=0;k<o;k++)
				{
					int x = a[i] + b[j] + c[k];
					if(f(x))
						s.add(x);
				}
		return s.size();
	}

}


import static java.lang.Math.*;

public class AlternateColors {

	private static String ans[] = new String[]{"RED", "GREEN" , "BLUE"};
	public String getColor(long r, long g, long b, long k) {
		long m = min(r,min(g,b));
		int ret = 0;
		if(k <= 3*m)
		{
			ret = (int)(k%3)-1;
			return ans[ret<0?2:ret];
		}
		r-=m;
		g-=m;
		b-=m;
		k-=3*m;
		if(r==0)
		{
			m = min(g,b);
			if(k <= 2*m)
			{
				ans = new String[]{"GREEN" , "BLUE"};
				ret = (int)(k%2)-1;
				return ans[ret<0?1:ret];
			}
			else
			{
				g-=m;
				b-=m;
				k-=2*m;
				if(g == 0)
					return ans[2];
				else return ans[1];
			}
		}
		else if(g==0)
		{
			m = min(r,b);
			if(k <= 2*m)
			{
				ans = new String[]{"RED" , "BLUE"};
				ret = (int)(k%2)-1;
				return ans[ret<0?1:ret];
			}
			else
			{
				r-=m;
				b-=m;
				k-=2*m;
				if(r == 0)
					return ans[2];
				else return ans[0];
			}
		}
		else
		{
			m = min(r,g);
			if(k <= 2*m)
			{
				ans = new String[]{"RED","GREEN"};
				ret = (int)(k%2)-1;
				return ans[ret<0?1:ret];
			}
			else
			{
				g-=m;
				r-=m;
				k-=2*m;
				if(r == 0)
					return ans[1];
				else return ans[0];
			}
		}
		
	} 			
}


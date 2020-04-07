public class FallingFactorialPower {

	
	public double compute(int n, int k) {
		double ans = 0.0;
		if(k==0)
			return 1.0;
		else if(k>0)
		{
			ans = n;
			for(int i=1;i<k;i++)
				ans*=(n-i);
		}
		else if(k<0)
		{
			ans = 1;
			for(int i=1;i<=-k;i++)
				ans/=(n+i);
				
			
		}
		return ans;
	}

}

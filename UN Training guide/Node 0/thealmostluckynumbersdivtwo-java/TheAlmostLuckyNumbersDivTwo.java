public class TheAlmostLuckyNumbersDivTwo {

	public boolean alucky(int x)
	{
		int y=0;
		while(x > 0)
		{
			int d = x % 10;
			if(d != 4 && d != 7)
			{
				y++;
				if(y>1)
					return false;
			}
			x/=10;
		}
		return true;
	}
	
	public int find(int a, int b) {
		int n=0;
		while(a <= b) 
		{
			if(alucky(a++))
				++n;
			
		}
		return n;
	}

}

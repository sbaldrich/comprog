import static java.lang.Math.*;

public class MagicalGirlLevelOneDivTwo {
	
	private static int D;

	public boolean bet(int a)
	{
		return -D <= a && a <=D;
	}
	
	public double dist(int p, int q, int x, int y)
	{
		return Math.sqrt((x-p)*(x-p) + (y-q)*(y-q));		
	}
	
	public double theMinDistance(int d, int x, int y)
	{
		D = d;
		x = abs(x); y = abs(y);
		if(bet(x) && bet(y))
			return 0.0;
		if(bet(x))
			return abs(y - d);
		if(bet(y))
			return abs(x - d);
		return dist(d,d,x,y);
	}
	


}

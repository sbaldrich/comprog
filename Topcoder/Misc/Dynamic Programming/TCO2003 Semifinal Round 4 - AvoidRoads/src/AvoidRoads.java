import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class AvoidRoads {
	long grid[][] = new long[110][110], hi;
	Set<String> badSet = new HashSet<String>();
	
	public boolean check(int a,int b,int c, int d)
	{
		if(badSet.contains(new StringBuilder().append(b).append(" ").append(a).append(" ").append(d).append(" ").append(c).toString())
			|| badSet.contains(new StringBuilder().append(d).append(" ").append(c).append(" ").append(b).append(" ").append(a).toString()))
			return false;
		return true;
	}
	
	public long numWays(int width, int height, String[] bad)
	{
		hi = 2;
		for(long i[] : grid)
			Arrays.fill(i, 0);
		for(int i=0;i<bad.length;i++)
			badSet.add(bad[i]);
		boolean ok = true;
		for(int i=1;i<=width;i++)
		{
			if(ok && !check(0,i-1,0,i))
				ok = false;
			if(ok)
				grid[0][i]=1;
		}
		ok = true;
		for(int i=1;i<=height;i++)
		{
			if(ok && !check(i-1,0,i,0))
				ok = false;
			if(ok)
				grid[i][0]=1;
		}
		
		for(int i=1;i<=height;i++)
			for(int j=1;j<=width;j++)
			{
				if(check(i,j-1,i,j))
					grid[i][j]+=grid[i][j-1];
				if(check(i-1,j,i,j))
					grid[i][j]+=grid[i-1][j];
				hi = Math.max(hi, grid[i][j]);
			}
		
		/*
		for(int i=0;i<=height;i++)
		{
			for(int j=0;j<=width;j++)
				System.out.printf("%"+(Math.log10(hi)+2)+"d",grid[i][j]);
			System.out.println();
		}*/
		return grid[height][width];
			
	}
}

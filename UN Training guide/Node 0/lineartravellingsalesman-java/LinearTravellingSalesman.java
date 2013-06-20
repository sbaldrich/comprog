import java.util.ArrayList;
import java.util.Arrays;

public class LinearTravellingSalesman {

	public class p implements Comparable<p>
	{
		int x , y;
		public p(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public int compareTo(p o) {
			int c = x-o.x;
			return c == 0? y-o.y : c;
		}		
	}
	public int findMinimumDistance(int[] x, int[] y) {
		int n;
		p points[] = new p[n=x.length];
		for(int i=0;i<x.length;i++)
			points[i] = new p(x[i],y[i]);
		Arrays.sort(points);
		n--;
		return Math.abs(points[n].x - points[0].x) + Math.abs(points[n].y - points[0].y);
	}

}

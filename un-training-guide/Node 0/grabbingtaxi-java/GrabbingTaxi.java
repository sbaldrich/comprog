import static java.lang.Math.*;
public class GrabbingTaxi {

	public int minTime(int[] tXs, int[] tYs, int gX, int gY, int wt, int tt) {
		int w = (abs(gX) + abs(gY)) * wt , t = Integer.MAX_VALUE;
		for(int i=0;i<tXs.length;i++)
		{
			int x = (abs(tXs[i]) + abs(tYs[i])) * wt;
			x+= tt* (abs(gX -tXs[i]) + abs(gY - tYs[i]));
			t = Math.min(x,t);
		}
		return Math.min(w,t);
	}

}

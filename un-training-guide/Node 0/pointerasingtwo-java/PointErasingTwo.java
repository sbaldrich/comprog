import static java.lang.Math.*;
public class PointErasingTwo {

	public int getMaximum(int[] y) {
		int i, j , k , n = y.length,ans = 0;
		for(i=0; i<n;i++)
			for(j=i+1; j<n;j++)
			{
				int y1 = min(y[i] , y[j]), y2 = y1 == y[i] ? y[j] : y[i];
				int t = 0;
				for(k=i+1; k<j;k++)
					if(y1 < y[k] && y[k] < y2)
						++t;
				ans = max(ans, t);
			}
		return ans;
	}

}

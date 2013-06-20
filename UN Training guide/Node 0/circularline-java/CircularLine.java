public class CircularLine {

	public int longestTravel(int[] t) {
		int n = t.length, ans = 0 , r, l;
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
			{
				r = l = 0;
				for(int k=i;k<j;k++)
					r+=t[k];
				for(int k=i-1;k>=0;k--)
					l+=t[k];
				for(int k=n-1;k>=j;k--)
					l+=t[k];
				ans = Math.max(Math.min(r,l), ans);
			}
		return ans;
	}

}

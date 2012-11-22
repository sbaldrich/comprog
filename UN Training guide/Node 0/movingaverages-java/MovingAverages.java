public class MovingAverages {

	public int[] calculate(String[] times, int) {
		int N = times.length, h,m,s, ans[] = new int[N-n +1];
		String t[];
		for(int i=0;i<=N-n;i++)
		{
			h = m = s = 0;
			for(int j=0;j<n;j++)
			{
				t = times[i+j].split(":");
				h += Integer.parseInt(t[0]);
				m += Integer.parseInt(t[1]);
				s += Integer.parseInt(t[2]);
			}
			h*=3600;
			m*=60;
			ans[i] = (h+m+s)/n;
		}
		return ans;
	}

}

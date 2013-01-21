public class Swimmers {

	public int[] getSwimTimes(int[] distances, int[] speeds, int current) {
		
		int n,ans[] = new int[n=distances.length];
		for(int i=0;i<n;i++)
		{
			if(distances[i] == 0)
				ans[i] = 0;
			else if(speeds[i] <= current)
				ans[i] = -1;
			else
			{
				ans[i]=(int)((distances[i]/(double)(speeds[i]+current)) + (distances[i]/(double)(speeds[i] - current)));				
			}
		}
		return ans;
	}

}

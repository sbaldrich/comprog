import java.util.HashSet;

public class VacationTime {

	public int bestSchedule(int N, int K, int[] workingDays) {
		HashSet<Integer> d = new HashSet<Integer>();
		for(int i : workingDays)
			d.add(i);
		int ans = Integer.MAX_VALUE;
		for(int i=1;i<=N-K+1;i++)
		{
			int x = 0;
			for(int j=i,k=0;k<K && j<=N;j++,k++)
			{
				if(d.contains(j))
					x++;
			}
			ans = Math.min(ans,x);
		}
		return ans;
	}

}

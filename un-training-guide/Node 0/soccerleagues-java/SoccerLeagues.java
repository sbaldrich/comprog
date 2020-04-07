public class SoccerLeagues {

	public int[] points(String[] matches) {
		int n, ans[] = new int[n=matches.length];
		for(int i=0;i<n;i++)
		{
			char[] arr = matches[i].toCharArray();
			for(int j=0;j<arr.length;j++)
			{
				if(arr[j] == 'W')
					ans[i]+=3;
				if(arr[j] == 'D')
				{
					ans[i]++;
					ans[j]++;
				}
				if(arr[j] == 'L')
					ans[j]+=3;
			}
		}
		for(int i : ans)
			System.out.print(i + " ");
		return ans;
	}

}

public class Filtering {

	public int[] designFilter(int[] sizes, String outcome) {
		int l=-1,r=-1;
		for(int i=0;i<sizes.length;i++)
		{
			if(outcome.charAt(i) == 'A')
			{
				if(l == -1)
					l = r = sizes[i];
				l = Math.min(sizes[i] , l);
				r = Math.max(sizes[i] , r);
			}
		}
		for(int i=0;i<sizes.length;i++)
			if(outcome.charAt(i) == 'R')
				if(sizes[i]>l && sizes[i] < r)
					return new int[0];
		return new int[]{l,r};
	}

}

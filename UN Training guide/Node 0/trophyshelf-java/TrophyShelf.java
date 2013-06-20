public class TrophyShelf {

	public int[] countVisible(int[] trophies) {
		int l=0,r=0,n=trophies.length;
		for(int i=0;i<n;i++)
		{
			boolean ok = true;
			for(int j=0;j<i && ok;j++)
				if(trophies[j] >= trophies[i])
					ok = false;
			if(ok)
				++l;
		}
		for(int i=n-1;i>=0;i--)
		{
			boolean ok = true;
			for(int j=n-1;j>i && ok;j--)
				if(trophies[j] >= trophies[i])
					ok = false;
			if(ok)
				++r;
		}
					
		return new int[]{l,r};
	}

}

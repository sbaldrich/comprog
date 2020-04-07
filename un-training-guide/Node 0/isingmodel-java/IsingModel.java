public class IsingModel {

	public int energy(String[] spins) {
		int ans = 0;
		int m = spins.length, n = spins[0].length();
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j<n-1)
				{
					if(spins[i].charAt(j) ==  spins[i].charAt(j+1))
						ans--;
					else 
						ans++;
				}
				if(i<m-1)
				{
					if(spins[i+1].charAt(j) == spins[i].charAt(j))
						ans -- ;
					else ans++;
				}
			}
		}
		return ans;
		
	}

}

public class TheMoviesLevelOneDivTwo {

	public int find(int n, int m, int[] row, int[] seat) {
		int ans=0,s[][] = new int[n][m];
		for(int i=0;i<row.length;i++)
			s[row[i]-1][seat[i]-1] = -1;
		for(int i=0;i<n;i++)
			for(int j=0;j<m-1;j++)
				if(s[i][j] != -1 && s[i][j+1] !=-1)
					ans++;
		return ans;
	}

}

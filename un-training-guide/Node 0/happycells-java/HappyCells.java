public class HappyCells {

	int ai[] = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	int aj[] = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

	int oi[] = new int[] { -1, 0, 1, 0 };
	int oj[] = new int[] { 0, 1, 0, -1 };

	int di[] = new int[] { -1, -1, 1, 1 };
	int dj[] = new int[] { -1, 1, 1, -1 };

	public int[] getHappy(String[] grid) {
		
		int m,n, ans[] = new int[3];
		char g[][] = new char[m=grid.length][n=grid[0].length()];
		for(int i=0;i<m;i++)
			g[i] = grid[i].toCharArray();
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				if(g[i][j] == '.')
				{
					boolean ok = true;
					for(int k=0;k<8 && ok;k++)
					{
						try {
							if(g[i+ai[k]][j+aj[k]] != 'X')
								ok=false;
						} catch (Exception e) {}
					}
					if(ok)
					{
						ans[0]++;
						continue;
					}
					ok = true;
					for(int k=0;k<4 && ok;k++)
					{
						try {
							if(g[i+oi[k]][j+oj[k]] != 'X')
								ok=false;
						} catch (Exception e) {}
					}
					if(ok)
					{
						ans[1]++;
						continue;
					}
					ok = true;
					for(int k=0;k<4 && ok;k++)
					{
						try {
							if(g[i+di[k]][j+dj[k]] != 'X')
								ok=false;
						} catch (Exception e) {}
					}
					if(ok)
					{
						ans[2]++;
						continue;
					}
				}
			}
		return ans;
	}
}

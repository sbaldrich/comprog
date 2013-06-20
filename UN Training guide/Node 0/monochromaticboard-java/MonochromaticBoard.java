public class MonochromaticBoard {

	public int theMin(String[] board) {
		int m = board.length, n = board[0].length(),ans=0;
		boolean col[] = new boolean[n] , row[] = new boolean[m] ;
		char b[][] = new char[m][n];
		for (int i = 0; i < m; i++)
			b[i] = board[i].toCharArray();

		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				col[j] |= b[i][j] == 'W';
				row[i] |= b[i][j] == 'W';
			}
			
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) 
			{
				int r = 0, d = 0;
				if (b[i][j] == 'B') 
				{
					for (int k = i + 1; k < m; k++)
					{
						if (b[k][j] == 'W')
							break;
						else
							d++;
					}

					for (int k = j + 1; k < n; k++)
					{
						if (b[i][k] == 'W')
							break;
						else
							r++;
					}
					r++; d++;
					if (row[i] || (!col[j] && !row[i] && d > r)) {
						for (int k = i, l = 0; k < m && l < d; k++, l++)
							b[k][j] = 'x';
					} else {
						for (int k = j, l = 0; k < n && l < r; k++, l++)
							b[i][k] = 'x';
					}
					ans++;
				}
			}
		return ans;
	}

}

public class SpidersOnTheGrid {

	public int find(String[] A) {
		int ans = 0, m = A.length, n = A[0].length();
		char old[][] = new char[m][n], g[][] = new char[m][n];
		for (int i = 0; i < m; i++)
			old[i] = A[i].toCharArray();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				try {
					char c = old[i][j];
					if (c == 'W')
						g[i][j - 1] = 'x';
					if (c == 'E')
						g[i][j + 1] = 'x';
					if (c == 'N')
						g[i-1][j] = 'x';
					if (c == 'S')
						g[i+1][j] = 'x';
				} catch (Exception e) {}
			}
		}
		for (int i = 0; i < m; i++) 
			for (int j = 0; j < n; j++)
				if (g[i][j] != 'x')
					++ans;
		return ans;
	}

}

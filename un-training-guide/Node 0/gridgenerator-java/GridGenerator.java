public class GridGenerator {

	public int generate(int[] row, int[] col) {
		int [][] grid = new int[row.length][row.length];
		grid[0] = row;
		for(int i=0;i<col.length;i++)
			grid[i][0] = col[i];
		for(int i=1;i<row.length;i++)
			for(int j=1;j<row.length;j++)
				grid[i][j] = grid[i-1][j-1] + grid[i-1][j] + grid[i][j-1];
		return grid[row.length-1][row.length-1];
	}

}

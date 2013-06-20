public class MatrixShiftings {

	public int minimumShifts(String[] matrix, int value) {
		int m = matrix.length , n = matrix[0].length();
		int d = -1;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				if(matrix[i].charAt(j) == '0'+value)
				{
					int x = Math.min(i , m - i) + Math.min(j , n-j);
					d = d == -1? x : Math.min(d,x);
				}
			}
		return d;
	}

}

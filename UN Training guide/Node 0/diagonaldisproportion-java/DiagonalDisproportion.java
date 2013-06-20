public class DiagonalDisproportion {

	public int getDisproportion(String[] matrix) {
		int n, ans = 0;
		char M[][] = new char[n = matrix[0].length()][n];
		for(int i=0;i<n;i++)
			M[i] = matrix[i].toCharArray();
		for(int i=0;i<n;i++)
		{
			ans+=M[i][i]-'0';
			ans-=M[i][n-1-i]-'0';
		}
		return ans;	
	}

}

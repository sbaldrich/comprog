public class TrainingCamp {

	public String[] determineSolvers(String[] att, String[] top) {
		int m = att.length , n = top.length, d = att[0].length();
		char ans[][] = new char[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				boolean ok = true;
				for(int k=0;k<d;k++)
				{
					if(att[i].charAt(k) == '-' && top[j].charAt(k) != '-')
						ok = false;
				}
				ans[i][j] = ok?'X':'-';
			}
		String[] ret = new String[m];
		for(int i=0;i<m;i++)
			ret[i] = new String(ans[i]);
		return ret;
	}

}

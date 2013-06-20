public class WhiteCells {

	public int countOccupied(String[] board) {
		int ans = 0;
		boolean white = true;
		for(String s : board)
		{
			char[] c = s.toCharArray();
			for(char pos : c)
			{
				if(pos == 'F' && white)
					ans++;
				white=!white;
			}
			white=!white;
		}
			
		return ans;
	}

}

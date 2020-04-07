public class TheBlackJackDivTwo {

	public int score(String[] cards) {
		int ans =0;
		for(String s:cards)
		{
			char c = s.charAt(0);
			if(c == 'A')
				ans+=11;
			else if(c == 'T' || c == 'J' || c == 'Q' || c == 'K')
				ans+=10;
			else
				ans+=c-'0';
		}
		return ans;
	}

}

public class ClockWalk {

	public int finalPosition(String flips) {
		int ans = 12;
		char[] s = flips.toCharArray();
		for(int i=0; i<s.length;i++)
		{
			if(s[i] == 'h')
			{
				ans = ans + i;
				ans = ans%12 + 1;
			}
			else
			{
				ans = ans - i - 1;
				ans %= 12;
				if(ans <= 0)
					ans+=12;
			}
		}
		return ans;
	}

}

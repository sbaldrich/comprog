public class OneDigitDifference {

	public int getSmallest(int N) {
		
		String s = ""+N;
		boolean flag = false;
		int i = 0;
		for(i=0;i<s.length();i++)
		{
			if(flag && s.charAt(i)!='0')
				break;
			if(s.charAt(i)!='0')
				flag = true;
		}
			
		if(i == s.length())
			return N==0?1:0;
		int ans = Integer.parseInt(s.substring(i));
		return ans == N?ans+1:ans;
	}

}

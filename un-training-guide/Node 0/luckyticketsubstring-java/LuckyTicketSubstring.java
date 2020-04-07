public class LuckyTicketSubstring {

	private static char[] s;
	
	private int l(int l, int r)
	{
		if((r - l +1) % 2 != 0)
			return 0;
		int m = (int)((r-l)/2.0), ls=0 ,rs=0;
		for(int i=l;i<=l+m;i++)
			ls+= (s[i] - '0');
		for(int i=l+m+1;i<=r;i++)
			rs+= (s[i] - '0');
		return ls == rs? r - l + 1 : 0;
	}
	public int maxLength(String str) {
		s = str.toCharArray();
		int n = str.length(),ans=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				ans = Math.max(ans,l(i,j));
		return ans;
	}

}

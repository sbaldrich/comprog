public class MegaCoolNumbersEasy {

	public boolean mc(int x)
	{
		if(x < 100)
			return true;
		char[] c = String.valueOf(x).toCharArray();
		int n = c[1] - c[0] - 2*('a');
		for(int i=2;i<c.length;i++)
		{
			if(c[i]-c[i-1]-2*('a') != n)
				return false;
		}
		return true;
	}
	public int count(int N) {
		int ans = 0;
		while(N>0)
			if(mc(N--))
				ans++;
		return ans;
	}

}

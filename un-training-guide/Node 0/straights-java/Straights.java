public class Straights {

	public int howMany(int[] hand, int k) {
		int ans = 0;
		for(int i=0;i<=13-k;i++)
		{
			int x = 1;
			for(int j=i,q=0;q<k;j++,q++)
				x*=hand[j];
			ans+=x;
		}
		return ans;
	}

}

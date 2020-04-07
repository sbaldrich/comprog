public class PersistentNumber {

	public int getPersistence(int n) {
		int ans = 0;
		while(n>=10)
		{
			int x = n , p=1;
			while(x>0)
			{
				p*=(x%10);
				x/=10;
			}
			n = p;
			++ans;
		}
		return ans;
	}

}

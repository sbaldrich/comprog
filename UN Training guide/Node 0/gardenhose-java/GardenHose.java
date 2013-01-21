public class GardenHose {

	public int countDead(int n, int rd, int cd, int hd) {
		int ans = n*n;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				if(rd*i <= hd || cd*j <= hd || rd*((n+1) - i) <= hd || cd*((n+1) - j) <= hd)
					--ans;
			}
		return ans;
	}

}

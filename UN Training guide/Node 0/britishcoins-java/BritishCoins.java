public class BritishCoins {

	public int[] coins(int pence) {
		int[] ans = {0, 0, 0};
		ans[0] = pence/(20*12);
		pence-=ans[0]*20*12;
		ans[1] = pence/12;
		pence-=ans[1]*12;
		ans[2] = pence;
		
		return ans;
	}

}

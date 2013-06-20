public class DigitHoles {

	private static final int holes[] = new int[]{0 , 0, 0 , 0 ,1 , 0 ,1 , 0 , 2 , 1};
	public int numHoles(int number) {
		char s[] = String.valueOf(number).toCharArray();
		int ans = 0;
		for(char c : s)
			ans += holes[c-'0'];
		return ans;
	}

}

public class Soccer {

	public int maxPoints(int[] wins, int[] ties) {
		int max = 0;
		for(int i=0;i<wins.length;i++)
		{
			int x = wins[i]*3 + ties[i];
			max = Math.max(x, max);
		}
		return max;
	}

}

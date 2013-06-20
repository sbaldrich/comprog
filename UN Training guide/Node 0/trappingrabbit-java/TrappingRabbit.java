public class TrappingRabbit {

	public int findMinimumTime(int[] trapX, int[] trapY) {
		int m = Integer.MAX_VALUE;
		for(int i=0;i<trapX.length;i++)
			m = Math.min(trapX[i]+trapY[i] - 2 , m);
		return m;
	}

}

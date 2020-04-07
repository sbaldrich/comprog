public class RosePetals {

	private static int petals[] = new int[]{0 , 0 , 0, 2 , 0 , 4 ,0};
	public int getScore(int[] dice) {
		int ans = 0;
		for(int i : dice)
			ans+=petals[i];
		
		return ans;
	}

}

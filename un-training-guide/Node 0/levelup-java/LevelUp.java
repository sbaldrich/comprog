public class LevelUp {

	public int toNextLevel(int[] en, int r) {
		int i=1;
		r -= en[0];
		while(i<en.length && r>=0)
			r = r - (en[i] - en[(i++)-1]);
		return Math.abs(r);
	}

}

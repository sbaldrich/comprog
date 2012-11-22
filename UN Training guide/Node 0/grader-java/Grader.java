public class Grader {

	public int[] grade(int[] pG, int[] aG) {
		int count[] = {0,0,0,0,0,0,0};
		int ans[] = {0,0,0,0,0,0,0};
		int n = pG.length;
		for(int i=0;i<n;i++)
			count[Math.abs((pG[i] - aG[i]))]++;
		for(int i=0;i<7;i++)
			ans[i] = (count[i]*100)/n;
		return ans;
	}

}

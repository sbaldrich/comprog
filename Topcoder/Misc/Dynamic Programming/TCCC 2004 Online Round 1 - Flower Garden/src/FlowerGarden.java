import java.util.Arrays;

/*
 * author: sbaldrich
 * Source: TCCC2003 Semifinals Div1 - 1 - FlowerGarden
 * 
 * DP. At first one might think a simple sort routine could help, but since there is no way
 * to sort the flowers only by comparing pairs, dp is the way to go. At each iteration get 
 * the next possible flower, in order to do so, check each of the unprocessed flowers to see
 * if there is another flower that makes it impossible to place it on front. If there are various
 * flowers that could be placed on front, take the tallest. O(n^3) 
 */
public class FlowerGarden {

	public int[] getOrdering(int[] h, int[] b, int[] w) {

		int n = h.length, i, j, k;
		int ans[] = new int[n];
		boolean done[] = new boolean[n];
		Arrays.fill(done, false);

		for (i = 0; i < n; i++) {
			int best = -1;
			for (j = 0; j < n; j++) 
				if (!done[j]) {
					boolean ok = true;
					for (k = 0; k < n; k++) {
						if (k != j && !done[k] && h[k] < h[j] && b[k] <= w[j]
								&& w[k] >= b[j])
							ok = false;
					}
					if (ok && (best == -1 || h[j] > h[best]))
						best = j;
				}
			ans[i] = h[best];
			done[best] = true;
		}
		return ans;
	}
}

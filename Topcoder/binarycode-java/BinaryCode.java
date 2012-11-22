public class BinaryCode {

	public String[] decode(String m) {
		int[] Q = new int[m.length()];
		int[] P = new int[m.length()];
		String ans[] = new String[2], str = "0";
		for (int i = 0; i < Q.length; i++)
			Q[i] = m.charAt(i) - '0';
		
		for (int x = 0; x < 2; x++) {
			P[0] = x;
			str=""+x;
			for (int i = 1; i < P.length; i++) {
				try {
					P[i] = Q[i - 1] - P[i - 1] - P[i - 2];
				} catch (Exception n) {
					P[i] = Q[i - 1] - P[i - 1];
				}
				str += "" + P[i];
				if (P[i] > 1 || P[i] < 0) {
					str = "NONE";
					break;
				}
			}
			try {
				if (Q[Q.length - 1] - P[Q.length - 1] - P[Q.length - 2] != 0)
					str = "NONE";
			} catch (Exception e) {
				if (Q[Q.length - 1] - P[Q.length - 1] != 0)
					str = "NONE";
			}
			ans[x] = str;
		}
		return ans;
	}

}

/*
 * Problem: SRM 354 - UnsealTheSafe
 * author: sbaldrich
 * 
 * DP. Since each state only depends on the previous one, we can have a matrix that stores the number
 * of different passwords that end on a specific digit. On each iteration we add the possibilities given
 * by the adjacent numbers. Implementation is the next issue, one can store all matrices up to N, but
 * since we only need the immediate previous state, two matrices are enough. 
 */


public class UnsealTheSafe {
	int dr[] = { 0, -1, 0, 1 };
	int dc[] = { -1, 0, 1, 0 };

	public long countPasswords(int N) {
		long[][] past = new long[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },{ 1, 0, 0 } };
		long[][] now= new long[4][3];
		long ans = 0;

		boolean go = false;
		for (int i = 1; i < N; i++) {
			if (i == N - 1)
				go = true;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == 3 && k > 0)
						break;
					now[j][k] = 0;
					for (int l = 0; l < 4; l++) {
						try {
							now[j][k] += past[j + dr[l]][k + dc[l]];
						} catch (Exception e) {} // :P, I know, this is quite awful.

					}
					if (go)
						ans += now[j][k];
				}
			}
			for(int j=0;j<4;j++)
				past[j] = now[j].clone(); 
		}
		return ans;
	}

}

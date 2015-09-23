import java.util.Arrays;
import java.util.Scanner;

public class TSHIRTS {

  static final int SHIRTS = 101;
  static final int MAX_N = 11;
  static final long MOD = (long) (1e9 + 7);
  static long dp[][] = new long[SHIRTS][(1 << MAX_N)];
  static boolean owns[][] = new boolean[SHIRTS][MAX_N];

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int cases = Integer.parseInt(sc.nextLine());
    while (cases-- > 0) {
      int n = Integer.parseInt(sc.nextLine());
      for (boolean[] sh : owns)
        Arrays.fill(sh, false);

      for (int i = 0; i < n; i++) {
        String tmp[] = sc.nextLine().split("\\s+");
        for (String sh : tmp)
          owns[Integer.parseInt(sh)][i] = true;
      }

      dp[0][0] = 1;
      for (int s = 1; s < SHIRTS; s++) {
        for (int m = 0; m < (1 << n); m++) {
          dp[s][m] = dp[s - 1][m];
          for (int j = 0; j < n; j++) {
            if (owns[s][j] && (m & (1 << j)) != 0) {
              dp[s][m] = (dp[s][m] + dp[s - 1][m ^ (1 << j)]) % MOD;
            }
          }
        }
      }

      System.out.println(dp[SHIRTS - 1][(1 << n) - 1]);
    }
    sc.close();
  }
}

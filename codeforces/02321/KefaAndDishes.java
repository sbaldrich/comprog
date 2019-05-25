import java.io.*;

public class KefaAndDishes {
  static int DISHES = 18;
  static long[][] dp = new long[1 << DISHES][DISHES];
  static long dish[] = new long[DISHES];
  static long boost[][] = new long[DISHES][DISHES];
  static BufferedReader in;
  static String pars[];
  static int n, m, k;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    pars = readLine();

    n = Integer.valueOf(pars[0]);
    m = Integer.valueOf(pars[1]);
    k = Integer.valueOf(pars[2]);

    pars = readLine();
    for (int i = 0; i < n; i++)
      dish[i] = Integer.valueOf(pars[i]);

    for (int i = 0, from, to, gain; i < k; i++) {
      pars = readLine();
      from = Integer.valueOf(pars[0]);
      to = Integer.valueOf(pars[1]);
      gain = Integer.valueOf(pars[2]);
      boost[from - 1][to - 1] = gain;
    }

    long ans = Integer.MIN_VALUE;

    for (int mask = 0; mask < (1 << n); mask++) {
      for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) == 0)
          continue;
        if (Integer.bitCount(mask) == 1) {
          dp[mask][i] = dish[i];
        } else {
          for (int j = 0; j < n; j++) {
            if (i != j && (mask & (1 << j)) != 0)
              dp[mask][i] = Math.max(dp[mask ^ (1 << i)][j] + boost[j][i]
                  + dish[i], dp[mask][i]);
          }
        }
        if (Integer.bitCount(mask) == m)
          ans = Math.max(ans, dp[mask][i]);
      }
    }

    System.out.println(ans);
  }

  private static String[] readLine() throws IOException {
    return in.readLine().split("\\s+");
  }
}

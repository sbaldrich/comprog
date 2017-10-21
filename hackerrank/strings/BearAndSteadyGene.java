import java.io.IOException;
import java.util.Arrays;
import java.io.*;

public class BearAndSteadyGene {

    static final int oo = 1 << 30;
    static int n, t;
    static int[][] counts = new int[200][500010], rcounts = new int[200][500010];
    static char[] letters = "ACGT".toCharArray();

    static boolean valid(int p, int q) {
        boolean ok = true;
        for (char c : letters) ok &= counts[c][p] + rcounts[c][q] <= t;
        return ok;
    }

    static boolean valid(int x, int[][] array) {
        boolean ok = true;
        for (char c : letters) ok &= array[c][x] <= t;
        return ok;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        final String string = reader.readLine();
        final char[] s = (" " + string).toCharArray();
        final char[] r = new StringBuilder(string + " ").reverse().toString().toCharArray();
        n = s.length;
        t = n / 4;
        for (int i = 0; i < s.length; i++) {
            for (Character c : Arrays.asList('A', 'G', 'T', 'C')) {
                counts[c][i] = (i == 0 ? 0 : counts[c][i - 1]) + (s[i] == c ? 1 : 0);
                rcounts[c][n - i - 1] = (i == 0 ? 0 : rcounts[c][n - i]) + (r[i] == c ? 1 : 0);
            }
        }
        int ans = oo;
        int q = 0;
        while (!valid(q, rcounts) && q < n) ++q;
        if (q > 0) {
            for (int p = 0; valid(p, counts) && q < n; q++) {
                while (valid(p, q)) {
                    ans = Math.min(ans, q - p++);
                }
            }
        } else{
            ans = 0;
        }
        System.out.println(ans);
    }

}


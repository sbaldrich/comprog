import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class CoinsAndQueries {
    public static void main(String[] args) throws IOException {
        ContestInputReader reader = new ContestInputReader(new InputStreamReader(System.in));
        int n = reader.nextInt(), q = reader.nextInt();
        int[] coins = new int[33];
        int largestCoin = 0;
        for (int i = 0; i < n; i++) {
            int lg = lg(reader.nextInt());
            largestCoin = Math.max(lg, largestCoin);
            coins[lg]++;
        }
        for (int i = 0; i < q; i++) {
            long query = reader.nextLong();
            int ans = 0;
            int currentCoin = largestCoin;
            int nextCoin;
            while (query > 0) {
                for (nextCoin = currentCoin; nextCoin >= 0; nextCoin--) {
                    if (coins[nextCoin] == 0) continue;
                    if (1 << nextCoin <= query) break;
                }
                if (nextCoin == -1) {
                    ans = -1;
                    break;
                } else {
                    long best = Math.min(coins[nextCoin], query / (1 << nextCoin));
                    ans += best;
                    query -= best * (1L << nextCoin);
                    currentCoin = nextCoin - 1;
                }
            }
            System.out.println(ans);
        }
    }

    static int lg(long n) {
        if (n <= 1) {
            return 0;
        } else {
            int ans = 0;
            while (n > 0) {
                n >>>= 1;
                ans++;
            }
            return ans - 1;
        }
    }

    static class ContestInputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public ContestInputReader(Reader ioReader) {
            reader = new BufferedReader(ioReader);
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}


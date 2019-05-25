import java.io.*;
import java.util.StringTokenizer;

/*
 * judge: codeforces
 * round: 02556
 * level: a
 * title: stock arbitraging
 * tags: [ad-hoc]
 * link: https://codeforces.com/contest/1150/problem/A
 */
public class StockArbitraging {
    public static void main(String args[]) throws IOException {
        ContestInputReader input = new ContestInputReader(new InputStreamReader(System.in));
        int n, m, money;
        n = input.nextInt();
        m = input.nextInt();
        money = input.nextInt();
        int bestBuy = 1001;
        int bestSell = 0;
        for (int i = 0; i < n; i++) {
            bestBuy = Integer.min(bestBuy, input.nextInt());
        }
        for (int i = 0; i < m; i++) {
            bestSell = Integer.max(bestSell, input.nextInt());
        }
        if (bestSell > bestBuy) {
            int shares = money / bestBuy;
            money = money + shares * (bestSell - bestBuy);
        }
        System.out.println(money);
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

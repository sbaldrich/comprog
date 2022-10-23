import java.io.*;
import java.util.StringTokenizer;

public class RoundDown {

    public static void main(String[] args) {
        ContestIO io = ContestIO.get("__input.txt");

        final int cases = io.nextInt();
        for (int i = 0; i < cases; i++) {
            final int m = io.nextInt();
            final int l10 = ((int) Math.log10(m));
            io.println(m - (int) Math.pow(10, l10));
        }
        io.close();
    }

    static class ContestIO {

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader;

        StringTokenizer tokenizer;

        ContestIO(Reader reader) {
            this.reader = new BufferedReader(reader);
        }

        static ContestIO get() {
            return new ContestIO(new InputStreamReader(System.in));
        }

        static ContestIO get(String file) {
            try {
                return new ContestIO(new FileReader(file));
            } catch (IOException ex) {
                return ContestIO.get();
            }
        }

        String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Couldn't read anything", e);
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        ContestIO printf(final String format, final Object... args) {
            out.printf(format, args);
            return this;
        }

        ContestIO println(final Object arg) {
            out.println(arg);
            return this;
        }

        void close() {
            out.close();
        }
    }

}


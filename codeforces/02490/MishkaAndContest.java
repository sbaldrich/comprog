import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class MishkaAndContest {

    public static void main(String[] args) throws IOException {
        ContestInputReader reader = new ContestInputReader(new InputStreamReader(System.in));
        int n = reader.nextInt();
        int k = reader.nextInt();
        boolean flag = false;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (reader.nextInt() <= k) {
                if (flag) {
                    right++;
                } else {
                    left++;
                }
            } else {
                flag = true;
                right = 0;
            }
        }
        System.out.println(left + right);
    }

    static class ContestInputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        ContestInputReader(Reader ioReader) {
            this.reader = new BufferedReader(ioReader);
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class AlphabeticRemovals {

    public static void main(String[] args) throws IOException {
        ContestInputReader reader = new ContestInputReader(new InputStreamReader(System.in));
        reader.nextInt(); // I don't care about this int.
        int k = reader.nextInt();
        char[] s = reader.nextLine().toCharArray();
        int counts[] = new int[26];
        for (char c : s) {
            counts[c - 'a']++;
        }
        int sum = 0;
        char limit = 'a';
        int ignore = 0;
        for (int i = 0; i < 26; i++) {
            sum += counts[i];
            limit = (char) ('a' + i);
            if (sum >= k) {
                ignore = counts[i] - (sum - k);
                break;
            }
        }
        int ignored = 0;
        for(char c : s){
            if(c < limit) continue;
            if(c == limit) {
                if(ignored < ignore){
                    ignored++;
                    continue;
                }
            }
            System.out.print(c);
        }
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

        String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}

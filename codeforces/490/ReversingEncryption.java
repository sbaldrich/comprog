import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class ReversingEncryption {

    public static void main(String[] args) throws IOException {
        ContestInputReader reader = new ContestInputReader(new InputStreamReader(System.in));
        int n = reader.nextInt();
        char[] chars = reader.nextLine().toCharArray();
        for(int d = 1; d <= n; d++){
            if(n % d != 0) continue;
            reverse(chars, 0, d - 1);
        }
        System.out.println(new String(chars));
    }

    private static void reverse(char[] array, int l, int r){
        for(int i = l, j = r; i < j; i++, j--){
            swap(array, i, j);
        }
    }

    private static void swap(char[] array, int p, int q){
        char t = array[p];
        array[p] = array[q];
        array[q] = t;
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

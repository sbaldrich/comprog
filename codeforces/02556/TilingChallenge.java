import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class TilingChallenge {

    static char[][] grid;

    public static void main(String[] args) {
        ContestInputReader reader = ContestInputReader.fromStdIn();

        int n = reader.nextInt();

        grid = reader.lines().map(String::toCharArray).toArray(char[][]::new);

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == '.') {
                    if (check(i, j)) {
                        fill(i, j);
                    }
                }
            }
        }

        String ans = "YES";

        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    ans = "NO";
                    break out;
                }

            }
        }
        System.out.println(ans);
    }

    static boolean check(int i, int j) {
        return grid[i - 1][j] == '.' && grid[i][j - 1] == '.' && grid[i + 1][j] == '.' && grid[i][j + 1] == '.';
    }

    static void fill(int i, int j) {
        grid[i][j] = '#';
        grid[i - 1][j] = '#';
        grid[i][j - 1] = '#';
        grid[i + 1][j] = '#';
        grid[i][j + 1] = '#';
    }

    static class ContestInputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        private ContestInputReader(Reader ioReader) {
            reader = new BufferedReader(ioReader);
        }

        static ContestInputReader fromFile(String fileName) {
            try {
                return new ContestInputReader(new FileReader(new File(fileName)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Couldn't read file " + fileName);
            }
        }

        static ContestInputReader fromStdIn() {
            return new ContestInputReader(new InputStreamReader(System.in));
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

        Stream<String> lines() {
            return reader.lines();
        }
    }
}

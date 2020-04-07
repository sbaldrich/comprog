import java.io.*;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        ContestInputReader reader = new ContestInputReader();
        int cases = reader.nextInt();
        for (int cn = 1; cn <= cases; cn++) {
            int N = reader.nextInt();
            int trace = 0;
            int M[][] = new int[N][N];
            boolean[][] cols = new boolean[N][N + 1];
            boolean[][] rows = new boolean[N][N + 1];
            boolean[] rcols = new boolean[N + 1];
            boolean[] rrows = new boolean[N + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = reader.nextInt();
                    if(i == j) trace += M[i][j];
                    rcols[j] |= cols[j][M[i][j]];
                    rrows[i] |= rows[i][M[i][j]];
                    cols[j][M[i][j]] = rows[i][M[i][j]] = true;
                }
            }
            int repcolcount = 0;
            int reprowcount = 0;
            for (int i = 0; i <= N; i++) {
                reprowcount += rrows[i] ? 1 : 0;
                repcolcount += rcols[i] ? 1 : 0;
            }
            System.out.printf("Case #%d: %d %d %d\n", cn, trace, reprowcount, repcolcount);
        }
    }
}

class ContestInputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    ContestInputReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    ContestInputReader(){
        this(new InputStreamReader(System.in));
    }

    public static ContestInputReader get(String file){
        if("true".equalsIgnoreCase(System.getProperty("nojudge"))){
            try {
                return new ContestInputReader(new FileReader(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new ContestInputReader();
    }

    String readLine(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read anything", e);
        }
    }

    String next(){
        while(tokenizer == null || ! tokenizer.hasMoreElements()){
            tokenizer = new StringTokenizer(readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt(){
        return Integer.parseInt(next());
    }
}


import java.io.*;
import java.util.*;

public class MirrorGrid {

    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");
        final var t = io.nextInt();
        for (int cc = 0; cc < t; cc++) {
            int n = io.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = Arrays.stream(io.next().split("")).mapToInt(c -> c.equals("0") ? 0 : 1).toArray();
            }
            int lim = n % 2 == 0 ? n - 1 : n - 2;
            int moves = 0;
            for (int k = 0; k < lim; k++) {
                for (int i = 0; i < n - 1 - 2*k; i++) {
                    int zeroes = 0, ones = 0;
                    if(grid[k][k + i] == 0) zeroes++; else ones++;
                    if(grid[k + i][n - 1 - k] == 0 ) zeroes++; else ones++;
                    if(grid[n - 1 - k][n - 1 - k - i] == 0) zeroes++; else ones++;
                    if(grid[n - 1 - k - i][k]== 0) zeroes++; else ones++;
                    moves += Math.min(zeroes, ones);
//                    io.printfln("Compare (%d, %d) (%d, %d) (%d, %d) (%d, %d)",
//                                k, k + i,
//                                k + i, n - 1 - k,
//                                n - 1 - k, n - 1 - k - i,
//                                n - 1 - k - i, k);
                }
            }
            io.println(moves);
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

        static ContestIO get(){
            return new ContestIO(new InputStreamReader(System.in));
        }

        static ContestIO get(String file){
            try{
                return new ContestIO(new FileReader(file));
            } catch(IOException ex){
                return ContestIO.get();
            }
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

        long nextLong(){
            return Long.parseLong(next());
        }

        ContestIO printf(final String format, final Object... args){
            out.printf(format, args);
            return this;
        }
        
        ContestIO printfln(final String format, final Object... args){
            printf(format, args);
            out.println();
            return this;
        }

        ContestIO println(final Object arg){
            out.println(arg);
            return this;
        }

        void close(){
            out.close();
        }
    }

}


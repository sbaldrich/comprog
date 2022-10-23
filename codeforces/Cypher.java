import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Cypher {

    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");
        int cases = io.nextInt();
        for (int cc = 0; cc < t; cc++) {
            final var n = io.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            for (int i = 0; i < n; i++) {
                var nmoves = io.nextInt();
                var moves = io.next().toCharArray();
                for (int k = 0; k < moves.length; k++) {
                    if(moves[k] == 'D'){
                        a[i] += 1;
                        if(a[i] > 9) a[i] = 0;
                    }
                    else {
                        a[i] -= 1;
                        if(a[i] < 0) a[i] = 9;
                    }
                }
            }
            final var ans = Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            io.println(ans);
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


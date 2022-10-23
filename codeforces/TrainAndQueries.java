import java.io.*;
import java.util.*;

public class TrainAndQueries {

    public static class Station {
        int left;
        int right;

        public Station(int left, int right){
            this.left = left;
            this.right = right;
        }

        public static Station of(int left, int right){
            return new Station(left, right);
        }
    }

    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");
        final int cases = io.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = io.nextInt(), k = io.nextInt();
            var memo = new HashMap<Integer, Station>();
            for(int i = 0; i < n; i++){
                int u = io.nextInt();
                Station prev = memo.get(u);
                if(prev != null){
                    prev.right = i;
                } else {
                    memo.put(u, Station.of(i, i));
                }
            }
            for (int i = 0; i < k; i++) {
                int a = io.nextInt(), b = io.nextInt();
                boolean possible = memo.containsKey(a) && memo.containsKey(b) && memo.get(a).left < memo.get(b).right;
                io.println(possible ? "YES" : "NO");
            }
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


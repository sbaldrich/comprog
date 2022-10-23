import java.io.*;
import java.util.*;

public class YetAnotherProblemAboutPairsSatisfyingAnInequality {

    static class Pair {
        int pos;
        int val;

        public Pair(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }

        public static Pair of(int pos, int val){
            return new Pair(pos, val);
        }

        public String toString(){
            return String.format("(%d, %d)", val, pos);
        }
    }
    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");
        final var cases = io.nextInt();
        int x;
        for (int cc = 0; cc < cases; cc++) {
            List<Pair> pairs = new ArrayList<>();
            int n = io.nextInt();
            for (int i = 1; i <= n; i++) {
               x = io.nextInt();
               if(x < i){
                   pairs.add(Pair.of(i, x));
               }
            }
            pairs.sort(Comparator.comparing(p -> p.val));
            long ans = 0;
            int left, right, mid, best;
//            io.println(pairs);
            Pair p, cur;
            for(int i = 0; i < pairs.size(); i++){
                cur = pairs.get(i);
                left = i + 1;
                right = pairs.size() - 1;
                best = -1;
//                io.printfln("cur: %s", cur);
                while(right >= left){
                    mid = (right + left) >>> 1;
//                    io.printf("r %d l %d m %d\n", right, left, mid);
                    p = pairs.get(mid);
                    if(p.val > cur.pos){
                        best = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
//                io.printfln("best: %d", best);
                if(best > -1){
                    ans += pairs.size() - best;
                }
            }
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


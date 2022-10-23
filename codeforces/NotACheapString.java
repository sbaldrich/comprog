import java.io.*;
import java.util.*;

public class NotACheapString {

    public static class Letter {
        int pos;
        int value;

        public Letter(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }

        public static Letter of(int pos, int value){
            return new Letter(pos, value);
        }
    }

    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");

        final var cases = io.nextInt();
        for (int cc = 0; cc < cases; cc++) {
            final var w = io.next().toCharArray();
            final int p = io.nextInt();
            int v = 0;
            List<Letter> letters = new ArrayList<>(w.length);
            Set<Integer> toRemove = new HashSet<>();
            for (int i = 0; i < w.length; i++) {
                int val = w[i] - 'a' + 1;
                v += val;
                letters.add(Letter.of(i, val));
            }
            letters.sort(Comparator.comparing(l -> -l.value));
            int index = 0;
            while(v > p && index < w.length){
                var removed = letters.get(index++);
                v -= removed.value;
                toRemove.add(removed.pos);
            }
            for (int i = 0; i < w.length; i++) {
                if(toRemove.contains(i)){
                    continue;
                }
                io.out.print(w[i]);
            }
            io.out.println();
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


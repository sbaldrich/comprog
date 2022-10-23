import java.io.*;
import java.util.*;

public class DoubleStrings {

    public static void main(String[] args){
        ContestIO io = ContestIO.get("__input.txt");
        final var cases = io.nextInt();
        for (int cc = 0; cc < cases; cc++) {
            int n = io.nextInt();
            List<String> strings = new ArrayList<>(n);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String string = io.next();
                strings.add(string);
                set.add(string);
            }
            StringBuilder ans = new StringBuilder();
            for (String s : strings) {
                boolean found = false;
                for (int i = 1; i < s.length(); i++) {
                    String left = s.substring(0, i);
                    String right = s.substring(i);
                    if(set.contains(left) && set.contains(right)){
                        found = true;
                        break;
                    }
                }
                ans.append(found ? "1" : "0");
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


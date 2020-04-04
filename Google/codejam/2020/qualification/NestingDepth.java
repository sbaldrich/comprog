import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NestingDepth {
    public static void main(String[] args) {
        List<String> open = Stream.iterate("", c -> c += "(").limit(10).collect(Collectors.toList());
        List<String> closed = Stream.iterate("", c -> c += ")").limit(10).collect(Collectors.toList());

        ContestInputReader reader = new ContestInputReader();
        int cases = reader.nextInt();
        for (int tc = 1; tc <= cases; tc++) {
            StringBuilder solution = new StringBuilder();
            int[] S = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int parCount = 0;
            for (int n : S) {
                if(n > parCount) solution.append(open.get(n - parCount));
                else if(n < parCount) solution.append(closed.get(parCount - n));
                solution.append(n);
                parCount = n;
            }
            solution.append(closed.get(parCount));
            System.out.printf("Case #%d: %s\n", tc, solution);
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


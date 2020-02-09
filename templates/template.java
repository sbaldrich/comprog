import java.io.*;
import java.util.*;

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

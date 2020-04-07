import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ParentingPartneringReturns {
    public static void main(String[] args) {
        ContestInputReader reader = new ContestInputReader();
        int cases = reader.nextInt();
        for (int cn = 1; cn <= cases; cn++) {
            String solution = "IMPOSSIBLE";
            int N = reader.nextInt();
            List<Task> tasks = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                tasks.add(new Task(i, reader.nextInt(), reader.nextInt()));
            }
            Collections.sort(tasks, Comparator.comparing(Task::getStart).thenComparing(t -> t.getEnd() - t.getStart()));
            int currentTask = 0;
            int climit = -1;
            int jlimit = -1;
            while(currentTask < N){
                Task t = tasks.get(currentTask);
                if(t.getStart() >= climit ){
                    climit = t.getEnd();
                    t.setOwner("C");
                    currentTask++;
                    continue;
                }
                if(t.getStart() >= jlimit){
                    jlimit = t.getEnd();
                    t.setOwner("J");
                    currentTask++;
                    continue;
                }
                break;
            }
            if(currentTask == N){
                Collections.sort(tasks, Comparator.comparing(Task::getIndex));
                solution = tasks.stream().map(Task::getOwner).collect(Collectors.joining());
            }
            System.out.printf("Case #%d: %s\n", cn, solution);
        }
    }
}

class Task{
    int index;
    int start;
    int end;
    String owner;

    public Task(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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


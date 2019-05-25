import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PolycarpsPockets {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine(); // We don't care about this line.
        final long mostRepetitions = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToLong(Long::intValue)
                .max().orElseThrow(RuntimeException::new);
        System.out.println(mostRepetitions);
    }
}

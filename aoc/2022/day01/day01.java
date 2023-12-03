import java.util.*;
import java.util.stream.*;
import java.nio.file.*;

class Day01 {
    
    public static void main(String[] args) throws Exception {
        var out = System.out;
        var maxThree =
            Arrays.stream(
                Files.newBufferedReader(Path.of("input.in"))
                .lines()
                .collect(Collectors.joining(" "))
                .split("  "))
            .map(it -> Arrays.stream(it.split(" "))
                 .map(Integer::valueOf)
                 .reduce(Integer::sum)
                 .orElseThrow()
                )
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .toList();

        // Part 1
        out.println(maxThree.get(0));
        // Part 2
        out.println(maxThree.stream().reduce(Integer::sum).orElseThrow());
        out.close();
    }

}

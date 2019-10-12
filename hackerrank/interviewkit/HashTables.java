import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Scratch {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> magazineSet = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> noteSet = Arrays.stream(note)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String word : note) {
            if(noteSet.get(word) > magazineSet.getOrDefault(word, 0L)){
                System.out.printf("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    public static void main(String[] args) {
        checkMagazine("give me one grand today night".split("\\s+"), "give one one grand today".split("\\s+"));
    }
}
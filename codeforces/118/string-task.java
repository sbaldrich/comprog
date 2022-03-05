import java.util.Scanner;

class StringTask {
    public static void main(String[] args) {
        System.out.println(new Scanner(System.in).nextLine().toLowerCase().replaceAll("[aeiouy]+", "").replaceAll("(.)", ".$1"));
    }
}
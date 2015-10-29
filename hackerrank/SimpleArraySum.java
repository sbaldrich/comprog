import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine(); //Ignore the first line.
        int sum = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer :: valueOf).sum();
        System.out.println(sum);
    }
}
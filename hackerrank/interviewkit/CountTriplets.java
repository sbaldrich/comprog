import java.nio.file.Files;
import java.util.*;
import java.io.*;

public class CountTriplets{
	public static void main(String args[]) throws IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			int[] tokens = null;
			tokens = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int n = tokens[0];
			int r = tokens[1];
			System.out.printf("%d %d\n", n, r);
			}
		}
}

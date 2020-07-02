import java.io.*;
import java.util.*;


public class Main {
	static final PrintWriter out = new PrintWriter(System.out);

	static class ContestInputReader {
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

		int[] nextIntArray(){
			return Arrays.stream(readLine().split("\\s+"))
						.mapToInt(Integer::parseInt)
						.toArray();
		}
	}

	public static void main(String[] args){
		ContestInputReader reader = new ContestInputReader();
		int n = reader.nextInt();
		int[] index = new int[n];
		int[] A = new int[n];
		for(int i = 0; i < n; i++){
			A[i] = reader.nextInt() - 1;
			index[A[i]] = i;
		}
		int best = 0;
		int cur = 0;
		int D[] = new int[2 * n + 1];
		for(int i = 0, p = 0, q = 0; i < n; i++){
			q = reader.nextInt() - 1;
			int d = (index[q] - i) % n;
			d = d < 0 ? d + n : d;
			D[n + d]++;
			best = Math.max(D[n + d], best);
		}
		out.println(best);
		out.close();
	}
}


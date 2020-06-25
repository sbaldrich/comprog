/*
 * To add subsequences to the string, it only makes sense to do it by
 * lumping equal characters together. Otherwise we'll just add to the string length
 * without gaining anything.
 */
import java.io.*;
import java.util.*;


class Main {

	public static void main(String[] args){
		ContestInputReader reader = new ContestInputReader();
		char[] S = "codeforces".toCharArray();
		int n = S.length;
		long k = reader.nextLong();
		long p = 1;

		int[] T = new int[n + 1];
		Arrays.fill(T, 1);
		for(int i = 0; p < k; i = (i + 1) % n){
			p /= T[i]++;
			p *= T[i];
		}
		for(int i = 0; i < n; i++ ){
			for(int j = 0; j < T[i]; j++){
				out.print(S[i]);
			}
		}
		out.close();
	}
	
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

		long nextLong(){
			return Long.parseLong(next());
		}
	}

}


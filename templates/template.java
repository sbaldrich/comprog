import java.util.*;
import java.io.*;

class Main {

		public static void main(String[] args){
				var fs = FastScanner.fromStdin();
				var out = System.out;
				// ::template-entry-point
				out.close();
		}
		
		static class FastScanner {
				BufferedReader br; 
				StringTokenizer st = new StringTokenizer("");

				private FastScanner(Reader reader){
						this.br = new BufferedReader(reader);
				}

				static FastScanner fromStdin(){
						return new FastScanner(new InputStreamReader(System.in));
				}
				
				static FastScanner fromFile(){
						try{
								return new FastScanner(new FileReader("input.in"));		
						} catch (FileNotFoundException ex){
								throw new RuntimeException(ex);
						}
				}
				
				String next() {
						while (!st.hasMoreTokens()) {
								try {
										st = new StringTokenizer(br.readLine());
								} catch (IOException e) {
								}
						}
						return st.nextToken();
				}

				int nextInt() {
						return Integer.parseInt(next());
				}

				int[] readArray() {
						try {
								String line = br.readLine().trim();

								if (line.isEmpty())
										return new int[0];

								String[] tokens = line.split("\\s+");

								int n = tokens.length;

								int[] a = new int[n];

								for (int i = 0; i < n; i++)
										a[i] = Integer.parseInt(tokens[i]);

								return a;
						} catch (IOException e) {
								throw new RuntimeException(e);
						}
				}

				int[] nextIntArray(int n) {
						int[] a = new int[n];
						for (int i = 0; i < n; i++)
								a[i] = nextInt();
						return a;
				}

				long nextLong() {
						return Long.parseLong(next());
				}
		}

}

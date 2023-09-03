import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Main {

		public static void main(String[] args){
				var fs = new FastScanner();
				var out = System.out;
				var sol = new Solution();
				out.println(sol.isPalindrome(fs.nextInt()));				
				out.close();
		}

		static class FastScanner {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer("");

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

class Solution {
		public boolean isPalindrome(int x){
				if(x < 0) return false;
				for(int l = 0, r = length(x) - 1; l < r; l++, r--){
						if(digit(x, l) != digit(x,r))
								return false;
				}
				return true;
		}

		private int length(int n){
				return (int) log10(gpowlt(n)) + 1;
		}

		private int digit(int n, int i){
				return (int) ((n /  (gpowlt(n) / (int) pow(10.0, i))) % 10);
		}
		
		private int gpowlt(int n){
				return (int) pow(10.0, (int) log10(n));
		}

}

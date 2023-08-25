import java.util.*;
import java.util.*;
import java.io.*;

class Main {

		public static void main(String[] args){
				var fs = new FastScanner();
				var out = System.out;
				var solution = new Solution();
				int[] nums = fs.readArray();
				int target = fs.nextInt();
				out.print(Arrays.toString(solution.twoSum(nums, target)));
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
		public int[] twoSum(int[] nums, int target){
				Map<Integer, Integer> memo = new HashMap<>();
				for(int i = 0; i < nums.length; i++){
						if(memo.containsKey(target - nums[i])){
								return new int[]{memo.get(target - nums[i]), i};
						}
						memo.put(nums[i], i);
				}
				throw new IllegalStateException("Problem constraints are not fulfilled");
		}
}


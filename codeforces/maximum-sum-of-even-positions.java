import java.io.*;
import java.util.*;

class Main {

	static class ContestIO {
		
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader reader;

		StringTokenizer tokenizer;

		ContestIO(Reader reader) {
			this.reader = new BufferedReader(reader);
		}

		static ContestIO get(){
			return new ContestIO(new InputStreamReader(System.in));
		}

		static ContestIO get(String file){
			try{
				return new ContestIO(new FileReader(file));
			} catch(IOException ex){
				return ContestIO.get();
			}
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

		long nextLong(){
			return Long.parseLong(next());
		}
	}


	public static void main(String[] args){
		ContestIO io = ContestIO.get("__input.txt");
		int cases = io.nextInt();
		while(cases -- > 0){
			int n = io.nextInt();
			long[] a = new long[n + 1];
			for(int i = 0; i < n; i++)
				a[i + 1] = io.nextLong();
			long[][] dp = new long[3][n + 1];
			dp[0][1] = dp[2][1] = a[1];
			for(int i = 2; i <= n; i++){
				dp[0][i] = dp[0][i - 1];
				dp[1][i] = max(dp[0][i - 2], dp[1][i - 2]);
				dp[2][i] = max(dp[0][i - 1], dp[1][i - 1], dp[2][i - 1]);
				if(i % 2 != 0){
					dp[0][i] += a[i];
					dp[1][i] += a[i - 1];
					dp[2][i] += a[i];
				} else{
					dp[1][i] += a[i];
				}
			}
			io.out.println(max(dp[0][n], dp[1][n], dp[2][n]));
		}
		io.out.close();
	}
	
	private static long max(long... A){
		long m = Long.MIN_VALUE;
		for(long i : A)
			m = m > i ? m : i;
		return m;
	}

}



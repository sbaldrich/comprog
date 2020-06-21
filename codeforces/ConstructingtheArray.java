import java.io.*;
import java.util.*;
import java.util.stream.*;


class Main {
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

	static class Segment implements Comparable<Segment>{
		int l, r;
		Segment(int l, int r){ this.l = l; this.r = r;}
		@Override
		public int compareTo(Segment that){
			int diff = (that.r - that.l) - (this.r - this.l);
			if( diff != 0) return diff;
			return this.l - that.l;
		}
	}

	static void solve(int[] A){
		int n = A.length;
		PriorityQueue<Segment> queue = new PriorityQueue<>(A.length);
		queue.add(new Segment(0, n - 1));
		int i = 1;
		while( !queue.isEmpty() ){
			Segment next = queue.remove();
			int p = (next.r + next.l) >>> 1;
			A[p] = i++;
			if(p > next.l) queue.add(new Segment(next.l, p - 1));
			if(p < next.r) queue.add(new Segment(p + 1, next.r));
		}
	}

	public static void main(String[] args){
		ContestInputReader reader = new ContestInputReader();
		int tc = reader.nextInt();
		while(tc --> 0){
			int n = reader.nextInt();
			int[] A = new int[n];
			solve(A);
			out.println(Arrays.stream(A).mapToObj(String::valueOf)
										.collect(Collectors.joining(" ")));
		}

		out.close();
	}
}


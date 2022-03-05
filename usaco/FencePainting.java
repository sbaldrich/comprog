import java.io.*;
import java.util.*;
import java.util.stream.*;


/*
    There are a couple of ways to solve the problem:
        1: Iterate between 1 and 100 and check whether i is inside any of the given ranges, if so, increase a counter.
        2: Check if the ranges overlap, if so, return the union as max(d,b) - min(a,c)
        2.1: Add both ranges and remove the intersection, the intersection between the ranges can be found as 
             max(min(b,d) - max(a,c), 0).
*/

public class FencePainting {
    static void solve(Kattio io){
        int a, b, c, d; 
        a = io.nextInt();
        b = io.nextInt();
        c = io.nextInt();
        d = io.nextInt();
        int total = b - a + d - c;
        int intersection = Math.max(Math.min(d, b) - Math.max(a, c), 0);
        int union = total - intersection; 
        io.println(union);
    }

    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("paint");
        solve(io);
        io.close();
    }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    public Kattio() {this(System.in, System.out);}
    public Kattio(InputStream i, OutputStream o){
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }
    // returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) {}
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}


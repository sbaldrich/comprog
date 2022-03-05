import java.io.*;
import java.util.*;
import java.util.stream.*;


public class BlockedBillboard {

    static class Rectangle {
        int x1, x2, y1, y2;
        Rectangle(Kattio io){
            this.x1 = io.nextInt();
            this.y1 = io.nextInt();
            this.x2 = io.nextInt();
            this.y2 = io.nextInt();    
        }

        int area(){
            return (y2 - y1) * (x2 - x1);
        }

        int intersection(Rectangle other){
            int xintersection = Math.max(Math.min(x2, other.x2) - Math.max(x1, other.x1), 0);
            int yintersection = Math.max(Math.min(y2, other.y2) - Math.max(y1, other.y1), 0);
            return xintersection * yintersection;
        }

    }

    static void solve(Kattio io){
        Rectangle b1 = new Rectangle(io);
        Rectangle b2 = new Rectangle(io);
        Rectangle t = new Rectangle(io);

        int visibleArea = b1.area() - b1.intersection(t) + b2.area() - b2.intersection(t); 
                
        io.println(visibleArea);
        
    }

    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("billboard");
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


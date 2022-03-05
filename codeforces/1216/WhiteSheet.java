import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class WhiteSheet {
    static void solve(Kattio io){
        Rectangle w = new Rectangle(io);
        Rectangle b1 = new Rectangle(io);
        Rectangle b2 = new Rectangle(io);

        Rectangle wb1 = w.intersect(b1);
        Rectangle wb2 = w.intersect(b2);
        Rectangle b = wb1.intersect(wb2);        
        long visibleArea = w.area() - wb1.area() - wb2.area() + b.area();
        io.println(visibleArea > 0 ? "YES" : "NO");
    }

    static class Rectangle {
        int x1, x2, y1, y2;

        Rectangle(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }        
        
        Rectangle(Kattio io){
            this(io.nextInt(),io.nextInt(),io.nextInt(),io.nextInt());
        }

        Rectangle intersect(Rectangle that){
            int xint = max(0, min(that.x2, x2) - max(that.x1, x1 )); 
            int yint = max(0, min(that.y2, y2) - max(that.y1, y1 ));
            if(1L * xint * yint == 0){
                return new Rectangle(0, 0, 0, 0);
            }
            return new Rectangle(max(x1,that.x1), max(y1,that.y1), min(x2, that.x2), min(y2, that.y2));
        }

        long area(){
            return 1L * (y2 - y1) * (x2 - x1);
        }

    }
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
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


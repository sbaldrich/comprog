import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Main {


	public static double getRad(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3)
	{
		double x = (p3.x * p3.x * (p1.y - p2.y)
				+ (p1.x * p1.x + (p1.y - p2.y) * (p1.y - p3.y))
				* (p2.y - p3.y) + p2.x * p2.x * (-p1.y + p3.y))
				/ (2 * (p3.x * ( p1.y - p2.y) + p1.x * (p2.y - p3.y) + p2.x
						* (-p1.y + p3.y)));
		double y = (p2.y + p3.y) / 2 - (p3.x - p2.x) /(p3.y - p2.y)
				* (x - (p2.x + p3.x) / 2);
		Point2D.Double c = new Point2D.Double(x,y);
		double ret = c.distance(p1);
		if(Double.isNaN(ret))
			ret = getRad(p2, p1, p3);
		//System.out.println("ret: " + ret);
		return ret;
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf;
		File f =  new File("438.in");
		if(f.exists())
			bf =  new BufferedReader(new FileReader(f));
		else bf =  new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		NumberFormat format = new DecimalFormat(".00"); 
		
		while((line = bf.readLine())!= null)
		{
			String pars[] = line.trim().split("[ ]+");
			Point2D.Double points[] =  new Point2D.Double[3];
			for(int i=0,j=0;i<6;i+=2,j++)
			{
				points[j] = new Point2D.Double(Double.parseDouble(pars[i]) , Double.parseDouble(pars[i+1]));
			}
			double r = getRad(points[0], points[1], points[2]);
			System.out.println(format.format(2*Math.PI*r));
		}

	}

}

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<Rectangle2D.Double> rects = new ArrayList<Rectangle2D.Double>();
		BufferedReader bf;
		File f = new File("476.in");
		if (f.exists())
			bf = new BufferedReader(new FileReader(f));
		else
			bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = bf.readLine()) != null) {
			line = line.trim();
			if (line.charAt(0) == '*')
				break;
			String[] pars = line.split("\\s+");
			Rectangle2D.Double r = new Rectangle2D.Double(
					Double.parseDouble(pars[1]), Double.parseDouble(pars[4]),
					Double.parseDouble(pars[3]) - Double.parseDouble(pars[1]), 
					Double.parseDouble(pars[2]) - Double.parseDouble(pars[4])
					);
			//System.out.println("rect: (" + r.getMinX() + "," + r.getMaxY() + ") (" + r.getMaxX() + "," +r.getMinY()+")"  );
			rects.add(r);
		}
		
			/*for(Rectangle2D.Double r : rects)
				System.out.println(r);*/
		
		//System.out.println(rects.get(0).contains(10.0,0.0));
		int p = 1;
		while ((line = bf.readLine()) != null) {
			String[] pars = line.split("\\s+");
			if(pars[0].equals("9999.9") && pars[1].equals("9999.9"))
				break;
			boolean ok = false;
			Point2D.Double pt =  new Point2D.Double(Double.parseDouble(pars[0]),Double.parseDouble(pars[1]));
			//System.out.println("pt: " + pt);
			for(int i=0;i<rects.size();i++)
			{
				if(rects.get(i).contains(pt))
				{
					ok = true;
					System.out.println("Point "+ (p) + " is contained in figure " + (i+1));
				}
			}
			if(!ok)
				System.out.println("Point "+p+" is not contained in any figure");
			p++;
		}

	}

}

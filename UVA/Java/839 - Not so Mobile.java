import java.io.*;
import java.util.*;

public class Main{
	private static BufferedReader reader;
	private static int w(String line) throws IOException{
		int l=0, r=0;
		String[] pars = line.split("\\s+");
		if(Integer.parseInt(pars[0]) == 0)
			l = w(reader.readLine());
		else l=Integer.parseInt(pars[0]);
		if(Integer.parseInt(pars[2]) == 0)
			r = w(reader.readLine());
		else r=Integer.parseInt(pars[2]);
		if(l == -1 || r == -1)
			return -1;
		if(l * Integer.parseInt(pars[1]) == Integer.parseInt(pars[3]) * r)
			return l+r;
		return -1;
	}

	private static File _f = new File("input.txt");
	
	public static void main(String args[]) throws Exception{

		if(!_f.exists())
			reader = new BufferedReader(new InputStreamReader(System.in));
		else 
			reader = new BufferedReader(new FileReader(_f));	
		int T = Integer.parseInt(reader.readLine().trim());
		reader.readLine();
		boolean nl = false;
		for(int tc=0;tc<T;tc++){
			if(nl)
				System.out.println();
			if(w(reader.readLine()) != -1)
				System.out.println("YES");
			else System.out.println("NO");
			nl = true;
			try{
				reader.readLine();
			}
			catch (Exception e){}
		}

	}
}

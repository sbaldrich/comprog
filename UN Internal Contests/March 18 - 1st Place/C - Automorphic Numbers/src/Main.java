import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf;
		File f = new File("C.in");
		if(f.exists())
			bf = new BufferedReader(new FileReader(f));
		else bf = new BufferedReader(new InputStreamReader(System.in));
		
		String line, na,nb;
		BigInteger bi, sq;
		while((line = bf.readLine())!=null)
		{
			if(line.charAt(line.length()-1)!= '5' && line.charAt(line.length()-1)!= '6')
			{
				System.out.println("Not an Automorphic number.");
				continue;
			}
			bi = new BigInteger(line);
			sq = bi.pow(2);
			//na = bi.toString();
			nb = sq.toString();
			if(bi.compareTo(BigInteger.ONE) > 0 && nb.length() - line.length() >=0 && nb.substring(nb.length() - line.length()).equalsIgnoreCase(line))
				System.out.printf("Automorphic number of %d-digit.\n" , line.length());
			else 
				System.out.println("Not an Automorphic number.");
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {


	static BigInteger f[] = new BigInteger[5010];
	
	public static void main(String[] args) throws Exception{
		f[0] = BigInteger.ZERO;
		f[1] = BigInteger.ONE;
		for(int i=2;i<5001;i++)
		{
			f[i] = f[i-1].add(f[i-2]);
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = bf.readLine()) != null )
		{
			int n = Integer.parseInt(line.trim());
			if(n>=0)
				System.out.println("The Fibonacci number for "+n+" is "+f[n]);
		}

	}

}

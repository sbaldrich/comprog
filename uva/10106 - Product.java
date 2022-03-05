import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = bf.readLine())!=null)
		{
			BigInteger a = new BigInteger(line.trim());
			line = bf.readLine();
			BigInteger b = new BigInteger(line.trim());
			System.out.println(a.multiply(b));
		}
	}

}

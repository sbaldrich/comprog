import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=bf.readLine()) != null)
		{
			BigInteger bi = new BigInteger(line.trim());
			bi = bi.multiply(bi.add(BigInteger.ONE)).divide(new BigInteger("2")).pow(2);
			System.out.println(bi);
		}
	}

}

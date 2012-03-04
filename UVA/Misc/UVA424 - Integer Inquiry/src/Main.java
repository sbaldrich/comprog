
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger total = new BigInteger("0");
        String line;
        while ((line = bf.readLine()) != null) {
            line = line.trim();
            BigInteger bi = new BigInteger(line);
            if (bi.equals(BigInteger.ZERO)) {
                break;
            }
            total = total.add(bi);
        }
        System.out.println(total);

    }
}

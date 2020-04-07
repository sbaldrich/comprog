import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValueAddedTax {

	public double calculateFinalPrice(String product, int price, String[] food) {
		Set<String> f= new HashSet<String>(Arrays.asList(food)); 
		if(f.contains(product))
			return (double)price * 1.1;
		else return (double)price * 1.18;
	}

}

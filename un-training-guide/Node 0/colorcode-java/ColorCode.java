import java.util.Arrays;
import java.util.List;

public class ColorCode {

	public long getOhms(String[] code) {
		String c[] = {"black" , "brown" , "red" , "orange" , "yellow"
				, "green" , "blue" , "violet" , "grey" , "white"};
		List<String> colors = Arrays.asList(c);
		long ans = (colors.indexOf(code[0])*10 + colors.indexOf(code[1])) * (long)Math.pow(10,colors.indexOf(code[2])); 
		return ans;
	}

}

import java.util.Arrays;

public class TriangleType {

	private static String ans[] = new String[]{"IMPOSSIBLE","ACUTE","OBTUSE","RIGHT"};
	
	public String type(int a, int b, int c) {
		int[] sides = new int[]{a,b,c};
		Arrays.sort(sides);
		a = sides[0];b = sides[1]; c = sides[2];
		
		if(a + b <= c)
			return ans[0];
		if(a*a + b*b == c*c)
			return ans[3];
		if(a*a + b*b < c*c)
			return ans[2];
		return ans[1];
		
	}

}

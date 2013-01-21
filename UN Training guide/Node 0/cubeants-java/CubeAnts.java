import java.util.HashSet;
import java.util.Set;

public class CubeAnts {

	public int getMinimumSteps(int[] pos) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i : pos)
			s.add(i);
		if(s.contains(6))
			return 3;
		if(s.contains(2) || s.contains(5) || s.contains(7))
			return 2;
		if(s.contains(3) || s.contains(1) || s.contains(4))
			return 1;
		return 0;
	}

}

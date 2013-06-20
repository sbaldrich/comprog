import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BunnyPuzzle {

	public int theCount(int[] bunnies) {
		int ans = 0 , n = bunnies.length;
		Set<Integer> b = new HashSet<Integer>();
		for(int i : bunnies)
			b.add(i);
		for(int i=0;i<n-1;i++)
		{
			int aim = 2*bunnies[i+1] - bunnies[i];
			if(!b.contains(aim))
			{
				int k = 0,j = i+1;
				while(k < 3 && j<n && bunnies[j++] <= aim)k++;
				if(k<2)
					++ans;
			}
			aim = 2*bunnies[i] - bunnies[i+1];
			if(!b.contains(aim))
			{
				int k = 0,j = i;
				while(k < 3 && j>-1 && bunnies[j--] >= aim)k++;
				if(k<2)
					++ans;
				
			}
		}
		return ans;
	}

}

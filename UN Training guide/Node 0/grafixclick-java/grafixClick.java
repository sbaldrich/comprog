import java.util.ArrayList;
import java.util.Arrays;

public class grafixClick {

	public int[] checkSaveButton(int[] mouseRows, int[] mouseCols) {
		int n = mouseRows.length;
		ArrayList<Integer> clicks = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(mouseRows[i]>= 20 && mouseRows[i]<=39 && mouseCols[i]>=50 && mouseCols[i]<=99)
				clicks.add(i);
		}
		int[] a = new int[clicks.size()];
		int p = 0;
		for(Integer i : clicks)
			a[p++] = i;
		
		return a;
	}

}

public class BunnyExamAfter {

	public int getMaximum(String black, String gray, String white) {
		int n =black.length(), ans=0;
		
		char x, y, z;
		for(int i=0;i<n;i++)
		{
			x = black.charAt(i);
			y = gray.charAt(i);
			z = white.charAt(i);
			if(y == z && x!= y)
				ans+=2;
			else if(x != y || x != z)
				ans++;
		}
		return ans;
	}

}

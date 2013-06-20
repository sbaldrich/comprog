public class FontSize {

	public int getPixelWidth(String sentence, int[] uppercase, int[] lowercase) {
		char str[] = sentence.toCharArray();
		int ans = 0;
		for(char c : str)
		{
			if(c == ' ')
				ans+=3;
			else if(Character.isUpperCase(c))
				ans+=uppercase[c-'A'];
			else
				ans+=lowercase[c-'a'];
			++ans;	
		}
		return --ans;
	}

}

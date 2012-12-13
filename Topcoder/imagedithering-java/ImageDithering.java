public class ImageDithering {

	public int count(String dithered, String[] screen) {
		char[] charray = dithered.toCharArray(), arr;
		int ans = 0;
		for(char c : charray )
		{
			for(String str : screen)
			{
				arr = str.toCharArray();
				for( char d : arr)
				{
					if(d == c)
						ans++;
				}
			}
		}
		return ans;
	}

}

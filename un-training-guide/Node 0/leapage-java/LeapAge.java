public class LeapAge {

	public boolean leap(int y)
	{
		if(y%4 == 0)
		{	
			if(y%100 == 0 && y%400 != 0)
				return false;
			return true;
		}
		return false;
	}
	
	public int getAge(int year, int born) {
		int ans = 0;
		while(++born <= year)
			if(leap(born))
				++ans;
		return ans;
	}

}

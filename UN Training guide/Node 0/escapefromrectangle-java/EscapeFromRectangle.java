public class EscapeFromRectangle {

	int min(int... m)
	{
		int x = 2000;
		for(int i:m)
			x = Math.min(x,i);
		return x;
	}
	public int shortest(int x, int y, int w, int h) {
		return min(y,h-y,x,w-x);
	}

}

public class AdditionCycles {

	int next(int n)
	{
		int sum = ((n/10)%10) + (n%10);
		return n%10 * 10 + sum%10;
	}
	
	public int cycleLength(int n) {
		int t = 1, x = next(n);
		for(;x!=n;x=next(x),t++);
		return t;
	}

}

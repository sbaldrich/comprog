public class Bits {

	public int minBits(int n) {
		
		return (int)(Math.log10(n)/Math.log10(2) + 1);
	}

}

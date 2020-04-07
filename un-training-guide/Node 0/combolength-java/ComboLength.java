public class ComboLength {

	public int howLong(String moves) {
		String a[] = moves.split("A+") , b[] = moves.split("B+");
		int m = 0;
		for(int i=0;i<a.length;i++)
			m = Math.max(m, a[i].length());
		for(int i=0;i<b.length;i++)
			m = Math.max(m, b[i].length());
		return m;
	}

}

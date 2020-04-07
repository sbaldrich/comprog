public class GuessingNextElement {

	public int guess(int[] A) {
		int n = A[1] - A[0],l = A.length;
		boolean ap = true;
		for(int i=2;i<l && ap;i++)
			if(A[i] - A[i-1] != n)
				ap=false;
		if(ap)
			return A[l-1] + n;
		else return A[l-1] * (A[1]/A[0]);
	}

}

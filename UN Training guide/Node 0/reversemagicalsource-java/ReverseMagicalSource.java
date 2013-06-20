public class ReverseMagicalSource {

	public int find(int source, int A) {
		int i=0,sum=0;
		while(sum<=A)
			sum+=source * Math.pow(10.0, i++);
		return sum;
	}

}

public class StairClimb {

	public int stridesTaken(int[] flights, int stairsPerStride) {
		int ans = 0;
		for(int i : flights)
			ans+=Math.ceil(i/(double)stairsPerStride);
		return ans+2*(flights.length-1);
	}

}

public class TrueSpace {

	public long calculateSpace(int[] sizes, int clusterSize) {
		long ans = 0L;
		for(int s : sizes)
		{
			ans+=Math.ceil(s/(double)clusterSize);
		}
		return ans*clusterSize;
	}

}

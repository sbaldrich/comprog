/*
 * author: sbaldrich
 * Source: TCCC2003 Semifinals Div1 - 1 - ZigZag
 * 
 * Simple DP problem, in order to get the longest zigzag sequence, two arrays are needed,
 * one to hold the length of the longest zigzag sequence when the current element is greater than
 * the one that goes immediately before and the other for the case when the current element
 * is less than the one before it. The rest is a simple matter of checking the right array when needed:
 * 
 * If we are considering the element as greater than the preceding one, we should check
 * the size of the longest zigzag sequence ending at the preceding elements when they're
 * considered as lesser than the one before them. The same applies the other way around
 * when considering the current element as greater than the one before it.
 */


public class ZigZag {

	public int longestZigZag(int[] sequence)
	{
		int n = sequence.length;
		int best = 1;
		int lt[] = new int[n] , gt[] = new int[n];
		for(int i=0;i<n;i++)
		{
			lt[i] = gt[i] = 1;
			for(int j=0;j<i;j++)
			{
				if(sequence[i]<sequence[j])
				{
					lt[i] = Math.max(gt[j] + 1, lt[i]);
					best = Math.max(best,lt[i]);
				}
				else if(sequence[i]>sequence[j])
				{
					gt[i] = Math.max(lt[j] + 1, gt[i]);
					best = Math.max(best,gt[i]);
				}
			}
		}
		return best;
	}

}

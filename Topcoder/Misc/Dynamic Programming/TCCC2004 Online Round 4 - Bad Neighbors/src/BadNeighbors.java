import java.util.Arrays;


/*
 * author: sbaldrich
 * Source: TCCC2004 Online Round 4 Div1 - 1 - BadNeighbors
 * 
 * 
 * It seems as a simple recursion ( no memo, no dp ) can be used in order to solve this problem, yet
 * I'm trying to learn DP so I've used it to solve the problem. 
 * Since the neighbors are a circular list, one has to manage this situation properly, as we know 
 * they won't be donating if their right or left neighbor does to, we know the first and last neighbor
 * won't be at the same time in an optimal solution, so we can simply split the circular list as to 
 * linear lists, one including the first but not the last and one inlcluding the last but not the first.
 * 
 * Now, to solve the problem with a linear list, we can use the following recurrence relation: 
 * f(i) = the maximal sum found considering the everyone up to i
 * so f(i) = max(f(i-2) + donation[i] , f(i-1) )   //consider the i'th neighbor or don't.
 * The last part is simply a matter of choosing the list that gives us the greater donation and there it is.
 */

public class BadNeighbors {

	public int maxSum(int[] in)
	{
		if(in.length == 1)
			return in[0];
		int n = in.length+1, best = -1;
		int[] f = new int[n];
		f[0] = 0;
		f[1] = in[0];
		for(int i=2;i<n;i++)
		{
			f[i] = Math.max(f[i-2] + in[i-1], f[i-1]);
			best = Math.max(best, f[i]);
		}
		for(int i=0;i<n;i++)
			System.out.print(f[i]+" ");
		System.out.println();
		return best;
	}
	
	public int maxDonations(int[] donations)
	{
		int n = donations.length;
		int[] A = Arrays.copyOfRange(donations,0,n-1), B = Arrays.copyOfRange(donations, 1, n);
		return Math.max(maxSum(A), maxSum(B));		
	}

}

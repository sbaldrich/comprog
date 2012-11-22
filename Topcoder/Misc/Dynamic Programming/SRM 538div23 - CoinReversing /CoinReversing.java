/*
 * Problem: CoinReversing
 * author: sbaldrich
 * 
 * Ok. This problem is very interesting. We know that the probability for a coin to get picked in a group
 * of a[i] coins is p = a[i]/N. So, in order for the coin to be heads up at any step, it must have been picked
 * an even number of times ( all coins start heads up ).
 * So, for any given coin, we know that in step 0, the probability that it will be heads up is 1.0 ( 0 is even )
 * on step 1, (an odd number) the probability that the coin is heads up is equal to the probability of not
 * having been chosen this time. So it would be (1-p).
 * The next step would be finding the not so easy to find recurrence. So, in the last step (t-1) we have two possible
 * situations, first, the number of times the coin was chosen on the previous step was odd and we chose it this time,
 * or the coin was not chosen and the number of times it was chosen previously is even. Wich would be p*(1-q) + q*(1-p).
 * We now just need to update the value of q and return the expected value and smile :D. 
 */

public class CoinReversing {

	public double expectedHeads(int N, int[] a) {
		double q = 1.0;
		for(int i=0;i<a.length;i++)
		{
			double p = a[i]/(double)N;
			q = (p*(1-q) + q*(1-p));
		}
		return N*q;
	}

}

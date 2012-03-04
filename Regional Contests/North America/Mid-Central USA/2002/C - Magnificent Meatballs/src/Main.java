import java.io.File;
import java.util.Scanner;


/*
 * Problem C - Magnificent Meatballs 
 * Source: Mid-Central USA 2002 Regional Contest
 * author: sbaldrich
 * 
 * Brute force gives the answer quite easily. Just try all possible stopping positions for Sam, sum both partitions
 * and check if they're equal.
 * O(n^2)
 */

public class Main {

	private static final String ans[] = {"No equal partitioning.\n" , "Sam stops at position %d and Ella stops at position %d.\n"};
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("C.in"));
		int places;
		while(true)
		{
			places = sc.nextInt();
			if(places == 0)
				break;
			int balls[] = new int[places];
			for(int i=0;i<places;i++)
				balls[i] = sc.nextInt();
			int i=0,j=0;
			boolean can = false;
			for(i=1;i<places;i++)
			{
				int sumSam = 0;
				int sumElla = 0;
				for(j=0;j<i;j++)
					sumSam+=balls[j];
				for(;j<places;j++)
					sumElla+=balls[j];
				if(sumSam == sumElla)
				{
					can = true;
					break;
				}
			}
			if(can)
				System.out.printf(ans[1], i,i+1);
			else
				System.out.printf(ans[0]);
		}
	}

}

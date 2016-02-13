import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * Problem F - Tanning Salon 
 * Source: Mid-Central USA 2002 Regional Contest
 * author: sbaldrich
 * 
 * Simple simulation, just check if whenever a new customer arrives, she was already tanning,
 * if not, check if there are beds available. If there are not, problem statement says she
 * will get the hell out of there, so add one to the counter. If you're handling the counter
 * as I am, divide by two (We're counting two times every walking customer). 
 */


public class Main {

	public static final String ans[] = {"All customers tanned successfully.\n" , "%d customer(s) walked away.\n"};
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("F.in"));
		
		int beds;
		String costumers;
		while(true)
		{
			beds = sc.nextInt();
			if(beds == 0)
				break;
			costumers = sc.next();
			int walk = 0;
			Set<String> tanning = new HashSet<String>();
			for(int i=0;i<costumers.length();i++)
			{
				if(tanning.contains(""+costumers.charAt(i)))
				{
					tanning.remove(""+costumers.charAt(i));
					beds++;
				}
				else if(beds>0)
				{
					tanning.add(""+costumers.charAt(i));
					beds--;
				}
				else
					walk++;
			}
			System.out.printf(ans[(walk>0?1:0)],walk/2);
		}
	}

}

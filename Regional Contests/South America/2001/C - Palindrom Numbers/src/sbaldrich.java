import java.io.File;
import java.util.Scanner;


public class Main {
	
	
	public static boolean ispal(String s)
	{
		for(int i=0;i<s.length()/2;i++)
		{
			if(s.charAt(i)!=s.charAt(s.length()-i-1))
				return false;
		}
		return true;
	}
	
	public static void process(int n)
	{
		boolean any = false;
		String x;
		for(int i=2;i<=16;i++)
		{
			x=Integer.toString(n, i).toUpperCase();
			//System.out.println("\n" + n + " in base " + i +": "+x);
			if(ispal(x))
			{
				if(!any)
				{
					any = true;
					System.out.print("Number "+n+" is palindrom in basis");
				}
				System.out.print(" " + i);
			}
		}
		if(!any)
			System.out.println("Number "+ n +" is not palindrom");
		else System.out.println();
		
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("C.in"));
		while(true)
		{
			int x = sc.nextInt();
			if(x == 0)
				break;
			process(x);
		}
	}
	
}

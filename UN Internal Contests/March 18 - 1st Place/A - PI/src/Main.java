import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	private static int gcd(int a, int b)
	{
		while( b != 0)
		{
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,x;
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				break;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				x = sc.nextInt();
				list.add(x);
			}
			int ans = 0;
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
				{
					if(gcd(list.get(i) , list.get(j)) == 1)
						ans++;
				}
			int pairs = 0;
			for(int i=1;i<n;i++)
				pairs+=i;
			if(ans == 0)
				System.out.println("No estimate for this data set.");
			else
				System.out.printf("%.6f\n",Math.sqrt((6*pairs/ans)));
		}
	}
}

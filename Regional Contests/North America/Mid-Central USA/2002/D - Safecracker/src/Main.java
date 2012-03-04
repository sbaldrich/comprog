import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


/*
 * Problem D - Safecracker 
 * Source: Mid-Central USA 2002 Regional Contest
 * author: sbaldrich
 * 
 * Brute force all the way to the answer. Just take the lexicographically greatest. There is some unnecessary 
 * reversal on the string in the code. Just ignore it. 
 */


public class Main {

	private static boolean ok(int... in)
	{
		for(int i=0;i<in.length;i++)
		{
			for(int j=i+1;j<in.length;j++)
				if(i!=j && in[i]==in[j])
					return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("D.in"));
		int target;
		String letters;
		while(true)
		{
			target = sc.nextInt();
			letters = sc.next();
			if(target == 0 && letters.compareTo("END") == 0)
				break;
			
			char let[] = letters.toCharArray(); 
			Arrays.sort(let);
			StringBuffer sb = new StringBuffer(new String(let));
			sb = sb.reverse();
			letters = sb.toString();
			int n = letters.length();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i]=letters.charAt(i)-'A'+1; 
			String ans = "";
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++)
					for(int k=0;k<n ;k++)
						for(int l=0;l<n ;l++)
							for(int m=0;m<n;m++)
							{
								if(!ok(i,j,k,l,m))
									continue;
									
								long X = a[i] - (a[j]*a[j])
										+ (a[k]*a[k]*a[k])
										- (a[l]*a[l]*a[l]*a[l])
										+ (a[m]*a[m]*a[m]*a[m]*a[m]);
								if(X == target)
								{
									String y = new StringBuilder().append(letters.charAt(i)).append(letters.charAt(j))
											.append(letters.charAt(k)).append(letters.charAt(l)).append(letters.charAt(m)).toString();
									if(ans.compareTo(y)<0)
										ans = y;
								}
							}
			System.out.println(ans.compareTo("")==0?"no solution":ans);
		}
	}

}

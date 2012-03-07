/*
 * Created on: Mar 6, 2012
 * Author: sbaldrich 
 * Problem K - King's Poker
 * Source: Latin America Regional contest 2011
 *
 * Too easy to explain. The code speaks for itself.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static String p(int[] a)
	{
		return String.format("%d %d %d" , a[0] , a[1] , a[2]);
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf;
		File f = new File("K.in");
		if(f.exists())
			bf = new BufferedReader(new FileReader(f));
		else bf = new BufferedReader(new InputStreamReader(System.in));
		String line , pars[];
		while((line = bf.readLine())!=null)
		{
			if(line.trim().compareTo("0 0 0") == 0)
				break;
			pars = line.split("[ ]+");
			int array[] = {Integer.parseInt(pars[0]), Integer.parseInt(pars[1]), Integer.parseInt(pars[2])};
			Arrays.sort(array);
			boolean isSet = false , isPair = false;
			int a =  array[0] , b = array[1] ,c  = array[2];
			if(a == b && b == c)
				isSet = true;
			if(a == b || b == c)
				isPair = true;
			if(isSet)
			{
				if( a == 13)
					System.out.println("*");
				else
					System.out.println((a+1) + " " + (a+1) + " " + (a+1) );
			}
			else if(isPair)
			{
				int x;
				if(a == b)
					x = c;
				else x = a;
				if(b == 13 && x == 12)
					System.out.println("1 1 1");
				else
				{
					while(true)
					{
						x++;
						if(x == 14)
						{
							x=1;
							b++;
						}
						if(x!=b)
							break;
					}
				array[0] = array[1] = b;
				array[2] = x;
				Arrays.sort(array);
				System.out.println(p(array));
				}
			}
			else System.out.println("1 1 2");
		}
	}
}

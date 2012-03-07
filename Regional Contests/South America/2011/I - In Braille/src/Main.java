
/*
 * Created on: Mar 6, 2012
 * Author: sbaldrich 
 * Problem I - In Braille
 * Source: Latin America Regional contest 2011
 *
 * Too easy to explain. The code speaks for itself.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class Main {
	public static String braille[] = {".***..","*....." , "*.*..." , "**...." , "**.*.." , "*..*.." , 
										"***..." , "****.." , "*.**.." , ".**..."};
	public static List<String> list = Arrays.asList(braille);
	public static BufferedReader bf;
	public static File f = new File("I.in");
	public static void main(String[] args) throws Exception{
		if(f.exists())
			bf = new BufferedReader(new FileReader(f));
		else bf = new BufferedReader(new InputStreamReader(System.in));
		int d;
		String line, pars[];
		String op;
		while((line = bf.readLine())!= null)
		{
			d =  Integer.parseInt(line);
			if(line.charAt(0) == '0')
				break;
			op = bf.readLine();
			if(op.charAt(0) == 'S')
			{
				line = bf.readLine();
				for(int i=0;i<6;i+=2)
				{
					for(int j=0;j<d;j++)
					{
						System.out.print(list.get(line.charAt(j) - '0').substring(i , i+2));
						if(j<d-1)
							System.out.print(" ");
					}
					System.out.println();
				}
			}
			else
			{
				String syms[] = new String[d];
				for(int i=0;i<d;i++)
					syms[i]="";
				for(int i=0;i<3;i++)
				{
					line = bf.readLine();
					pars = line.split("\\s+");
					for(int j=0;j<d;j++)
						syms[j]+=pars[j];
				}
				for(int i=0;i<d;i++)
					System.out.print(list.indexOf(syms[i]));
				System.out.println();
			}
		
		}
	}
	
}

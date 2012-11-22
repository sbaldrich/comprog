import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
 * Created on: Feb 23, 2012
 * Author: sbaldrich 
 * Problem J - Jupiter Attacks!
 * Source: Latin America Regional contest 2011
 *
 * 
 */
public class Main {

	public static long powermod(long b , long p , long m)
	{
		if(p == 0)
			return 1;
		if(p%2 == 0)
		{
			long x = powermod(b,p/2,m);
			return (x*x)%m;
		}
		else return ((b%m) * powermod(b,p-1,m)) %m ; 
	}
	
	private static int B,L,N;
	private static long P;
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader;
		File f = new File("j.in");
		if(f.exists())
			reader = new BufferedReader(new FileReader(f));
		else 
			reader = new BufferedReader(new InputStreamReader(System.in));
		String line,  pars[];
		while((line = reader.readLine())!=null)
		{
			if(line.trim().compareTo("0 0 0 0") == 0)
				break;
			pars = line.split("\\s+");
			
			B = Integer.parseInt(pars[0]);
			P = Integer.parseInt(pars[1]);
			L = Integer.parseInt(pars[2]);
			N = Integer.parseInt(pars[3]);
			
			long tree[] = new long[2 * ((1 << (int) (log(L) / log(2)) + 1))];
			
			//System.out.println(String.format("Tree has %d elements" , tree.length));
			for(int i=0;i<N;i++)
			{
				line = reader.readLine();
				pars = line.split("\\s+");
				//System.out.println(line);
				if(pars[0].charAt(0) == 'E')
				{
					edit(1, 1 , L, tree, Integer.parseInt(pars[1]) , Integer.parseInt(pars[2]));
					/*for(int n : tree)
						System.out.print(n+" ");
					System.out.println();*/
				}
					
				else
					System.out.println(hash(1, 1, L, tree, Integer.parseInt(pars[1]) , Integer.parseInt(pars[2]),0)) ;
			}
			System.out.println("-");
		}
		
	}

	private static long hash(int node, long l, long r, long[] tree, int i, int j , long offset) {
		//System.out.println(String.format("Called with %d %d %d %d %d", node, l, r, i, j));
		if(i > r || j < l)
			return 0;
		if(l>=i && r<=j)
		{
			//System.out.println("Satisfies condition 2 :D");
			return (tree[node] %P * (long)powermod(B,offset,P))%P;
		}
		
		
		//System.out.println(String.format("Standing on %d %d" , l , r));
		long m = (l+r)/2;
		//System.out.println("On left, p= " + (j-m));
		//System.out.println("On right, p= " + (j-r));
		long left  = hash(node*2 , l ,  m , tree, i, j , j-m); 
		long right = hash(node*2+1, m+1, r , tree, i, j, j-r); 
		//System.out.println(String.format("on %d %d got %d %d " , l,r, left , right));
		return (left + right)%P;
	}

	private static void edit(int node, int l, int r, long[] tree, int pos,  int val) {
		if(pos < l || pos > r)
			return;
		if(l == pos && r == pos)
		{
			tree[node] = val;
			return;
		}
		int m = (l+r)/2;
		edit(node*2 ,  l, m ,  tree , pos , val);
		edit(node*2+1, m+1 ,r, tree , pos , val);
		
		long left = ((tree[2*node] * (long)powermod(B,r-m,P) % P));
		long right = tree[node*2+1];
		//System.out.println(String.format("left=%d , right=%d" , left , right));
		tree[node] = (left + right);
		
	}
	
}

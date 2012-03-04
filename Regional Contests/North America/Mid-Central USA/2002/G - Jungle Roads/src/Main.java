/*
 * Problem G - Jungle Roads 
 * Source: Mid-Central USA 2002 Regional Contest
 * author: sbaldrich
 * 
 * This problem cryes out loud I'M AN MST! PLEASE USE PRIM'S ALGORITHM ON ME!!
 * O(n^2). 
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int prim(int[][] g)
	{
		int n;
		boolean intree[] = new boolean[n=g.length];
		Arrays.fill(intree, false);
		intree[0] = true;
		int q,w=0,ans=0;
		for(int i=1;i<n;i++)
		{
			q = -1;
			for(int j=0;j<n;j++)
				if(intree[j])
					for(int k=0;k<g[j].length;k++)
						if(!intree[k] && (g[j][k]<Integer.MAX_VALUE) && (q==-1|g[j][k]<w))
						{
							q = k;
							w = g[j][k];
						}
			intree[q] = true;
			ans += w;
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("G.in"));
		int nodes;
		while(true)
		{
			nodes = sc.nextInt();
			if(nodes == 0)
				break;
			int graph[][] = new int[nodes][nodes];
			for(int[] a:graph)
				Arrays.fill(a, Integer.MAX_VALUE);
			String x,y; //Node x has n adjacent nodes, y is each of them and w is the weight of the path
			int n,w;
			for(int i=0;i<nodes-1;i++)
			{
				x = sc.next();
				n = sc.nextInt();
				for(int j=0;j<n;j++)
				{
					y = sc.next();
					w = sc.nextInt();
					graph[x.charAt(0) - 'A'][y.charAt(0)- 'A'] = w;
					graph[y.charAt(0) - 'A'][x.charAt(0)- 'A'] = w;
				}
			}
			System.out.println(prim(graph));
		}
	}

}

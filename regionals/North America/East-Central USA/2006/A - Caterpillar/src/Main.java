import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: A - Caterpillar 
 * Author: sbaldrich
 * 
 * If a graph is a caterpillar it must: be connected, have no cycles, form a simple path when looked without its leaves.
 * A simple condition that it must fulfill is that there are exactly n-1 edges ( if there are less, it must be disconnected,
 * if there are more, it must have at least one cycle) I didn't really check for simple paths in a common dfs way, what I
 * did after removing the leaves was just to check if no node has more than one leave connected to it.  
 * O( :D )
 */

public class Main {

	public static class Graph
	{
		ArrayList<HashSet<Integer>> edges;
		int n,count;
		
		private Graph(){
			edges = new ArrayList<HashSet<Integer>>();
		};
		public Graph(int n)
		{
			this.n = n;
			edges = new ArrayList<HashSet<Integer>>();
			for(int i=0;i<=n;i++)
				edges.add(new HashSet<Integer>());
		}
		public void addEdge(int x,int y)
		{
			edges.get(x).add(y);
			edges.get(y).add(x);
		}
		public boolean connected_and_acyclic()
		{
			boolean visit[] = new boolean[n+1];
			Arrays.fill(visit,false);
			if(!dfs(visit, 1, 0))
				return false;
			for(int i=1;i<=n;i++)
				if(!visit[i])
					return false;
			return true;
		}
		
		private boolean dfs(boolean[] visit, int x, int parent) {
			if(visit[x])
				return false;
			visit[x] = true;
			boolean ok = true;
			for(Integer p : edges.get(x))
			{
				if(p == parent)
					continue;
				if(visit[p])
					return false;
				ok &= dfs(visit, p , x);
			}
			return ok;
		}
		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=n;i++)
			{
				sb.append(i +": ");
				for(Integer p : edges.get(i))
				{
					sb.append(p + " ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
		 
		public Graph clone()
		{
			Graph clone = new Graph();
			for(int i=0;i<=n;i++)
				clone.edges.add((HashSet<Integer>)this.edges.get(i).clone());
			clone.n = n;
			return clone;
		}
	}
	public static void main(String[] args)throws Exception {
		//Scanner sc = new Scanner(new File("A.in"));
		Scanner sc = new Scanner(System.in);
		int n, e, x, y, graphNo = 1;
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				break;
			e = sc.nextInt();
			Graph g = new Graph(n);
			for(int i=0;i<e;i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				g.addEdge(x, y);
			}
			boolean cat = false;
			cat = g.connected_and_acyclic() && (e == n-1);
			if(cat)
			{
				Graph pruned = g.clone();
				for(int i=1;i<=n;i++)
				{
					if(g.edges.get(i).size() == 1)
					{
						int q = g.edges.get(i).iterator().next();
						pruned.edges.get(q).remove(i);
						pruned.edges.get(i).clear();
					}
				}
				for(int i=1;i<=pruned.n;i++)
				{
					if(pruned.edges.get(i).size()>1)
					{
						boolean leave = false;
						for(Integer p : pruned.edges.get(i))
						{
							if(pruned.edges.get(p).size() == 1)
							{
								if(leave == true)
								{
									cat = false;
									break;
								}
								else
									leave = true;
							}
						}
					}
				}
					
						
			}
			System.out.println("Graph "+(graphNo++)+" is "+(!cat?"not ":"")+"a caterpillar.");
		}
	}

}

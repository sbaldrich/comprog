import static java.lang.Math.log;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static int E[] = new int[200020];
	public static int L[] = new int[200020];
	public static int R[] = new int[100010];
	public static long W[] = new long[100010];
	public static int M[] = new int[100010];

	static ArrayList<ArrayList<Integer>> graph;
	static HashMap<Pair,Integer> cost;
	static int pos;
	
	
	
	public static void dfs(int node, int level, long w) {
		pos++;
		E[pos] = node;
		L[pos] = level;
		if (R[node] == -1) {
			R[node] = pos;
			W[node] = w;
		}
		for (Integer i : graph.get(node)) {
			dfs(i, level + 1, w + cost.get(p(node,i)));
			pos++;
			E[pos] = node;
			L[pos] = level;
		}

	}

	
	public static void initSegmentTree(int N) {
		
		Arrays.fill(M, -1);
		f(1, 0, N - 1, M);
	}

	private static void f(int node, int l, int r, int[] M) {
		if (l == r)
			M[node] = l;
		else {
			f(2 * node, l, (l + r) / 2, M);
			f(2 * node + 1, (l + r) / 2 + 1, r, M);
			if (L[M[2 * node]] <= L[M[2 * node + 1]])
				M[node] = M[2 * node];
			else
				M[node] = M[2 * node + 1];
		}
	}

	public static int query(int node, int l, int r, int i,int j) {
		int p1, p2;

		if (i > r || j < l)
			return -1;
		if (i <= l && j >= r)
			return M[node];
		

		p1 = query(2 * node, l, (l + r) / 2, i, j);
		p2 = query(2 * node + 1, (l + r) / 2 + 1, r,  i, j);

		if (p1 == -1 || p2 == -1)
			return (p1 == -1 ? p2 : p1);

		return L[p1] <= L[p2]?p1:p2;
	}
	
	public static void clear(int n)
	{
		pos = -1;
		graph = new ArrayList<ArrayList<Integer>>();
		cost = new HashMap<Pair, Integer>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<Integer>());
		for(int i=0;i<n;i++)
			R[i] = -1;
	}
	public static void main(String[] args) throws Exception {
		File f = new File("ants.in");
		BufferedReader reader;
		if (f.exists())
			reader = new BufferedReader(new FileReader(f));
		else
			reader = new BufferedReader(new InputStreamReader(System.in));
		String line, pars[];
		int i, x, y, w, q, k, l; // k is auxiliar, use it for anything
		while ((line = reader.readLine()) != null) {
			int N = Integer.parseInt(line.trim());
			if (N == 0)
				break;
			clear(N);
			for (i = 1; i < N; i++) {
				line = reader.readLine();
				pars = line.split("\\s+");
				y = Integer.parseInt(pars[0]);
				w = Integer.parseInt(pars[1]);

				graph.get(k = min(i, y)).add(l=max(i, y));
				cost.put(p(k,l), w);
			}
			//dump(N);
			dfs(0, 0, 0);
			//dump(N);
			initSegmentTree(N);
			line = reader.readLine();
			q = Integer.parseInt(line.trim());
			for (i = 0; i < q; i++) {
				line = reader.readLine();
				pars = line.split("\\s+");
				x = Integer.parseInt(pars[0]);
				y = Integer.parseInt(pars[1]);
				int rX = R[x] , rY = R[y];
				k = min(rX,rY) ; l = (k==rX?rY:rX);
				long ans = W[x] + W[y];
				ans-=2*W[E[query(0,0,N-1,k,l)]];
				System.out.print(ans);
				if(i<q-1)
					System.out.print(" ");
				else 
					System.out.println();
			}
		}

	}

	/*
	 * Helpers
	 */

	public static class Pair
	{
		int p,q;
		Pair(int p, int q)
		{
			this.p = p ;
			this.q = q;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			Pair o = (Pair)obj;
			return o.p == this.p && o.q == this.q;
		}
		@Override
		public int hashCode()
		{
			return (this.q - this.p) * (this.q + this.p); 
		}
	}
	
	public static Pair p(int p , int q)
	{
		return new Pair(p,q);
	}
	
	public static void dumpGraph(ArrayList<ArrayList<Integer>> g)
	{
		for(int i=0;i<g.size();i++)
		{
			System.out.print(i+" -> { ");
			for(int j=0;j<g.get(i).size();j++)
				System.out.print(g.get(i).get(j) + " ");
			System.out.print("}");
			System.out.println();
		}
		System.out.println("\n*\n");
	}
	
	public static void dump(int n) {
		System.out.println("E");
		for (int i=0;i<2*n-1;i++)
			System.out.print(E[i] + " ");
		System.out.println();
		System.out.println("L");
		for (int i=0;i<2*n-1;i++)
			System.out.print(L[i] + " ");
		System.out.println();
		System.out.println("R");
		for (int i=0;i<n;i++)
			System.out.print(R[i] + " ");
		System.out.println();
		System.out.println("W");
		for (int i=0;i<n;i++)
			System.out.print(W[i] + " ");
		System.out.println();
	}
	
	
}

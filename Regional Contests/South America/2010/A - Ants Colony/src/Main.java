import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	private static final int NN = 100050;

	private static int P[][] = new int[NN][17], L[] = new int[NN];
	private static long W[] = new long[NN];

	public static void main(String[] args) throws Exception {
		File f = new File("ants.in");
		BufferedReader reader;
		if (f.exists())
			reader = new BufferedReader(new FileReader(f));
		else
			reader = new BufferedReader(new InputStreamReader(System.in));
		String line, pars[];
		int a, b, N, q;
		long w;
		while ((line = reader.readLine()) != null) {
			N = Integer.parseInt(line.trim());
			if (N == 0)
				break;
			P[0][0] = -1;
			W[0] = L[0] = 0;
			for (int i = 1; i < N; i++) {
				line = reader.readLine();
				pars = line.split("\\s+");
				a = Integer.parseInt(pars[0]);
				w = Long.parseLong(pars[1]);
				for (int j = 0; (1 << j) < N; ++j)
					P[i][j] = -1;
				P[i][0] = a;
				L[i] = L[a] + 1;
				W[i] = W[a] + w;
			}

			for (int j = 1; (1 << j) < N; j++)
				for (int i = 0; i < N; i++) {
					if(P[i][j-1]!=-1)
						P[i][j] = P[P[i][j-1]][j-1];
				}
			
			line = reader.readLine();
			q = Integer.parseInt(line.trim());
			while(q-- > 0)
			{
				line = reader.readLine();
				pars = line.split("\\s+");
				a = Integer.parseInt(pars[0]);
				b = Integer.parseInt(pars[1]);
				System.out.printf("%d%c" , W[a] + W[b] - (W[query(a,b)] << 1) , (q>0?' ':'\n'));
			}
		}
	}
	
	private static int query(int p, int q)
	{
		int log , i, x;
		if(L[p]< L[q])
		{
			x = p;
			p = q;
			q = x;
		}
		for(log=1;(1<<log)<=L[p];log++);
		log--;
		for (i = log; i >= 0; i--)
			if (L[p] - (1 << i) >= L[q])
				p = P[p][i];
		if (p == q)
			return p;
		for (i = log; i >= 0; i--)
			if (P[p][i] != -1 && P[p][i] != P[q][i])
			{
				p = P[p][i]; q = P[q][i];
			}
		return P[p][0];
	}
	
}

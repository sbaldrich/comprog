import static java.lang.Math.*;

public class VendingMachine {

	private static int actual = 0;
	private static int best = 0;
	private static int columns = 0;
	private static int time = 0;
	private static boolean debug = true;
	
	private static void sof(String format, Object... o)
	{
		System.out.printf(format, o);
	}
	private static void debf(String format , Object... o)
	{
		if(debug)
			sof(format , o);
	}
	private static void deb(Object o)
	{
		if(debug)
			System.out.println(o);
	}
	
	private int move(int to) {
		int cost = min(abs(actual - to), columns - abs(actual - to));
		actual = to;
		return cost;
	}

	public void show(int[][] m, int[] c) {
		if(!debug)
			return;
		for (int[] i : m) {
			for (int j : i)
				sof("%5s ", j == 0?"*":j);
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<columns;i++)
			System.out.print("******");
		System.out.println();
		for (int i : c)
			sof("%5d ", i);
		System.out.println();
	}

	public int motorUse(String[] prices, String[] purchases) {
		debug = false;
		debf("%10s\n" , "	*****");
		time = actual = columns = best = 0;
		columns = prices[0].split("[ ]+").length;
		int[][] machine = new int[prices.length][columns];
		int[] cost = new int[columns];
		int ans = 0;
		for (int i = 0; i < machine.length; i++) {
			String str[] = prices[i].split("[ ]+");
			for (int j = 0; j < columns; j++) {
				machine[i][j] = Integer.parseInt(str[j]);
				cost[j] += machine[i][j];
				if (cost[j] > cost[best])
					best = j;
			}
		}
		show(machine, cost);
		ans += move(best);
		int m , n , t;
		for (String purch : purchases) {
			debf("Processing purchase <%s>\n" , purch);
			String pars[] = purch.split("[,:]");
			m = Integer.valueOf(pars[0]);
			n = Integer.valueOf(pars[1]);
			t = Integer.valueOf(pars[2]);
			debf("t = %d\n" , t);
			debf("time = %d\n" , time);
			debf("t - time = %d\n" , t-time);
			if ((t - time) >= 5) {
				ans += move(best);
				deb("*ans: " + ans);
			}
			time += t - time;
			if (machine[m][n] == 0)
				return -1;
			cost[n] -= machine[m][n];
			machine[m][n] = 0;
			ans += move(n);
			best = 0;
			for (int i = 0; i < columns; i++) {
				if (cost[i] > cost[best])
					best = i;
			}
			//show(machine, cost);
			deb("actual: " + actual);
			deb("ans: " + ans);
			debf("Best is %d \n", best);
			
			
		}
		//show(machine, cost);
		ans += move(best);
		return ans;
	}
}

public class MostProfitable {

	public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
		int best = 0 , id=0;
		for(int i=0;i<costs.length;i++)
		{
			int x = sales[i] * (prices[i] - costs[i]);
			if(x > best)
			{
				best = x;
				id = i;
			}
				
		}
		if(best <= 0)
			return "";
		return items[id];
	}

}

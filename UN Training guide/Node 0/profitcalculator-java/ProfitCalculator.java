public class ProfitCalculator {

	public int percent(String[] items) {
		double cost=0.0 , payment = 0.0;
		String pars[];
		for(String s : items)
		{
			pars = s.split(" ");
			payment+=Double.parseDouble(pars[0]);
			cost+=Double.parseDouble(pars[1]);
		}
		double profit = payment - cost;
		return cost==0.0?(int)payment:(int)(profit*100/payment);
	}

}

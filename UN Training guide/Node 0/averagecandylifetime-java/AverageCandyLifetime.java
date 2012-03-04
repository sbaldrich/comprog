public class AverageCandyLifetime {

	public double getAverage(int[] eatenCandies) {
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
		for(int i=1;i<12;i++)
			days[i] += days[i-1];
		double candy = 0;
		double lifetime = 0; 
		for(int i=0;i<12;i++)
		{
			candy+=eatenCandies[i];
			lifetime+= eatenCandies[i] * days[i];
		}
		return candy == 0?0 : lifetime/candy;
	}

}

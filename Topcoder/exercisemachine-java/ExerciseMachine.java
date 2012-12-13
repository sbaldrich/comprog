public class ExerciseMachine {

	private final double eps = 1e-9; 
	public boolean isInt(double x)
	{
		double z =(double)((int)x);
		if(x-z<eps)
			return true;
		else return false;
	}
	public int getPercentages(String time) {
		String[] p = time.split(":");
		int secs=0, div=3600; 
		for(int i=0;i<3;i++)
		{
			secs += Integer.valueOf(p[i])*div;
			div/=60;
		}
		for(int i=1;i<100;i++)
		{
			double x = i*secs/100.0;
			if(isInt(x))
			{
				return 99/i;
			}
		}
		return 0;
	}

}

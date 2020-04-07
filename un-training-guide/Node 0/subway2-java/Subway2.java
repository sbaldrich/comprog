public class Subway2 {

	public double minTime(int length, int a, int mv) {
		double tm = mv/(double)a , pos = tm*tm*a*0.5,ans=0.0;
		if(pos > 0.5 * length)
		{
			ans = 2*Math.sqrt(length/(double)a);
		}
		else
		{
			double rem = (double)length - 2.0*pos;
			ans = 2.0*tm + (double)rem/(double)mv;
		}
		return ans;
	}

}

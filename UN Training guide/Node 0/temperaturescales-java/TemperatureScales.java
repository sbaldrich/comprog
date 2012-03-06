public class TemperatureScales {

	public double convert(int f1, int b1, int f2, int b2, int t) {
		double a = (double)(f2-b2)/(double)(f1-b1) , b = (double)f2-a*f1;
		return a*t+b;
	}

}

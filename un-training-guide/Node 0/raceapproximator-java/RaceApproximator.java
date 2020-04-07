import static java.lang.Math.*;
public class RaceApproximator {

	public String timeToBeat(int d1, int t1, int d2, int t2, int raceDistance) {
		double t = t1*exp(log(t2/(double)t1)*(log(d1/(double)raceDistance)/log(d1/(double)d2)));
		long time = (long)t;
		long h , m;
		h = time/3600;
		time-=h*3600;
		m=time/60;
		time-=m*60;
		return String.format("%d:%2d:%2d", h, m , time).replaceAll(" ", "0");
	}

}

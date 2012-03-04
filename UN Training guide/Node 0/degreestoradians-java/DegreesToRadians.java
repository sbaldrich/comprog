public class DegreesToRadians {

	public double convertToRadians(int degrees, int minutes, int seconds) {
		double deg = degrees , min = minutes , sec = seconds;
		
		return (deg + min/60 + sec/3600)*Math.PI/180.;
	}

}

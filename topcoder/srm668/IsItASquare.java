public class IsItASquare{
	public int distSq(int x1, int y1, int x2, int y2){
		int dx = x2 - x1;
		int dy = y2 - y1;
		return dx * dx + dy * dy;
	}

	public String isSquare(int[] x, int[] y){
		for(int a = 0; a < 4; a++){
			for(int b = 0; b < 4; b++){
				for(int c = 0; c < 4; c++){
					int d = 0;
					while( (d == a) || (d == b) || (d == c) )
						d++;
					int ab = distSq( x[a], y[a], x[b], y[b] );
					int bc = distSq( x[b], y[b], x[c], y[c] );
					int cd = distSq( x[c], y[c], x[d], y[d] );
					int da = distSq( x[d], y[d], x[a], y[a] );
					int ac = distSq( x[a], y[a], x[c], y[c] ) ;
					int bd = distSq( x[b], y[b], x[d], y[d] ) ;

					if( (ab == bc) && (bc == cd) && (cd == da) && (ac == bd) )
						return "It's a square";
				}
			}
		}
		return "Not a square";
	}
}

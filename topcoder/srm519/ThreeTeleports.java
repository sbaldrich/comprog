import java.math.*;

public class ThreeTeleports{

	private long hx, hy, ans;
	private long[][] in, out;
	
	private long d( long x1, long y1,  long x2, long y2 ){
		return Math.abs( x2 - x1 ) + Math.abs( y2 - y1 );
	}
	
	public void solve( long x, long y, long time, int tele ){
		if( x == hx && y == hy ){
			ans = Math.min( time, ans );
			return;	
		}
		solve( hx, hy, time + d( x, y, hx, hy), tele );
		for( int i = 0; i < 3; i++ ){
			if( ( tele & ( 1 << i ) ) == 0 )
				solve( out[i][0], out[i][1], time + 10 + d( x, y, in[i][0], in[i][1]), tele | ( 1 << i ) );
		}
		for( int i = 0; i < 3; i++ ){
			if( ( tele & ( 1 << i ) ) == 0 )
				solve( in[i][0], in[i][1], time + 10 + d( x, y, out[i][0], out[i][1]), tele | ( 1 << i ) );
		}
	}													
	
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports){
		ans = Integer.MAX_VALUE;
		hx = xHome;
		hy = yHome;
		in = new long[3][2];
		out = new long[3][2];
		for( int i = 0; i < 3; i++ ){
			String pars[] = teleports[i].split(" ");
			in[i][0] = Long.parseLong( pars[0] );
			in[i][1] = Long.parseLong( pars[1] );
			out[i][0] = Long.parseLong( pars[2] );
			out[i][1] = Long.parseLong( pars[3] );
		}
		solve( xMe, yMe, 0, 0 );
		return (int)ans;		
	}
}


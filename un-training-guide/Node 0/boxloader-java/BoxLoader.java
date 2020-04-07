
public class BoxLoader {

	public int mostItems(int bx, int by, int bz, int ix, int iy, int iz) {
		int c, m=0;
		c=(bx/ix)*(by/iy)*(bz/iz); if(c>m)m=c;
		c=(bx/ix)*(by/iz)*(bz/iy); if(c>m)m=c;
		c=(bx/iy)*(by/ix)*(bz/iz); if(c>m)m=c;
		c=(bx/iy)*(by/iz)*(bz/ix); if(c>m)m=c;
		c=(bx/iz)*(by/ix)*(bz/iy); if(c>m)m=c;
		c=(bx/iz)*(by/iy)*(bz/ix); if(c>m)m=c;
		return m;
	}

}
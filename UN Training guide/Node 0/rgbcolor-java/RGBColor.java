
public class RGBColor {

	public int[] getComplement(int[] rgb) {
		int ans[] = new int[3];
		for(int i=0;i<3;i++)
			ans[i]= 255 - rgb[i];
		for(int i=0;i<3;i++)
			if(Math.abs(rgb[i] - ans[i]) > 32)
				return ans;
		int x[] = new int[3];
		for(int i=0;i<3;i++)
		{
			x[i] = rgb[i] + 128;
			if(x[i] > 255)
				x[i] = rgb[i] - 128;
		}
		return x;
		
	}

}

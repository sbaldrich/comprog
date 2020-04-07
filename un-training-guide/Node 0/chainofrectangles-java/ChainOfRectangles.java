import java.util.Arrays;

public class ChainOfRectangles {

	public int getMaximalArea(int[] width, int[] height, String color) {
		String str= "RGB";
		int[] area = new int[3];
		char arr[] = color.toCharArray(), cur=' ';
		
		for(int i=0;i<arr.length;i++)
		{
			if(i>0)
			{
				area[str.indexOf(cur)]-=width[i]*height[i];
			}
			area[str.indexOf(arr[i])]+=width[i]*height[i];
			cur = arr[i];
		}
		Arrays.sort(area);
		return area[2];
	}

}

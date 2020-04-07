public class FowlRoad {

	public int crossings(int roadY, int[] bobX, int[] bobY) {
		boolean up = bobY[0]<roadY;
		int ans = 0;
		for(int i=1;i<bobY.length;i++)
		{
			if(up && bobY[i] > roadY)
			{
				up = false;
				++ans;
			}
			else if(!up && bobY[i] < roadY)
			{
				up = true;
				++ans;
			}
		}
		return ans;
	}

}

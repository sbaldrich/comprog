public class AimToTen {

	public int need(int[] marks) {
		int sum = 0, n=0;
		double avg = 0.0;
		for(int i=0;i<marks.length;i++)
			sum+=marks[i];
		avg = sum/(double)marks.length;
		while(avg < 9.5)
		{
			++n;
			sum+=10;
			avg = sum/(double)(marks.length + n);
		}
		return n;
	}

}

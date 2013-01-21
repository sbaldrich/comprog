public class PassingGrade {

	public int pointsNeeded(int[] pointsEarned, int[] pointsPossible, int finalExam) {
		int pe = 0 , pp = finalExam;
		for(int i=0;i<pointsEarned.length;i++)
		{
			pe+=pointsEarned[i];
			pp+=pointsPossible[i];
		}
		int pn = (int)Math.ceil(0.65*pp);
		
		if(pn-pe > finalExam)
			return -1;
		return Math.max(0 , pn-pe);
	}

}

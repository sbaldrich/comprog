import java.text.DecimalFormat;

public class TournamentJudging {

	private static int round(double n)
	{
		return (int)(n + 0.5);
	}
	public int getPoints(int[] rawScores, int[] conversionFactor) {
		int score = 0;
		for(int i =0;i<rawScores.length;i++)
		{
			score+= round((double)(rawScores[i]/(double)conversionFactor[i]));
		}
		
		
		return score;
	}

}

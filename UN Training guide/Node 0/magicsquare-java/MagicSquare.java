public class MagicSquare {

	public int missing(int[] square) {
		int pos = 0;
		for(;square[pos]!=-1;pos++);
		
		if(pos < 3)
		{
			int sum = square[3] + square[4] + square[5];
			return sum - (square[0] + square[1] + square[2] + 1);
		}
		if(pos < 6)
		{
			int sum = square[0] + square[1] + square[2] ;
			return sum - (square[3] + square[4] + square[5] + 1);
		}
		else
		{
			int sum = square[3] + square[4] + square[5];
			return sum - (square[6] + square[7] + square[8] + 1);
		}
	}

}

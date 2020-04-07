public class Chessboard {

	public String changeNotation(String cell) {
		String abc = "abcdefgh"; 
		if(cell.matches("[a-h][1-8]"))
		{
			char[] c = cell.toCharArray();
			return ""+ ((c[1] - '0' - 1) * 8 + (c[0] - 'a' + 1));
		}
		else
		{
			int x = Integer.valueOf(cell), l = x%8 -1;
			l = l<0?l+8:l;
			return String.format("%c%d", abc.charAt(l) ,(int)Math.ceil(x/8.0));
		}
	}

}

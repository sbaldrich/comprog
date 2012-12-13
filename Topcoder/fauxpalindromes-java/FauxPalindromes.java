public class FauxPalindromes {

	private static String ans[] = new String[]{"PALINDROME" , "FAUX" , "NOT EVEN FAUX"};
	private boolean pal(String s) {
		for(int i=0, j=s.length()-1; i<j; i++, j--)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;
		}
		return true;
	}
	private boolean faux(String s) {
		char cur  =s.charAt(0), next;
		String str = "" + cur;
		int i = 0;
		while(i<s.length())
		{
			next = s.charAt(i++);
			if(next != cur)
				str+=next;
			cur = next;
		}
		return pal(str);
	}
	public String classifyIt(String word) {
		if(pal(word))
			return ans[0];
		if(faux(word))
			return ans[1];
		return ans[2];
	}

}

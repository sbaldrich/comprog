public class AppleWord {

	public int minRep(String word) {
		word = word.toLowerCase();
		if(word.length() < 5)
			return -1;
		if(word.matches("app+le"))
			return 0;
		char s[] = word.toCharArray();
		int n = s.length, ans=n;
		if(s[0] == 'a')
			--ans;
		if(s[n-1] == 'e')
			--ans;
		if(s[n-2] == 'l')
			--ans;
		for(int i=1;i<n-2;i++)
			if(s[i] == 'p')
				--ans;
		return ans;
	}

}

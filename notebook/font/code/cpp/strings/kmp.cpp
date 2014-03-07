vector<int> kmp(string text, string pattern){
	int m = pattern.size() , n = text.size();
	vector<int> T(m + 1, -1), matches;
	if(m == 0){
		matches.push_back(0);
		return matches;
	}
	for(int i = 1; i <= m; i++){
		int pos = T[i - 1];
		while(pos != -1 && pattern[pos] != pattern[i - 1]) 
			pos = T[pos];
		T[i] = pos + 1;
	}
	int tp = 0,pp = 0;
	while(tp < n){
		while(pp != -1 && (pp == m || pattern[pp] != text[tp]))
			pp = T[pp];
		pp++;
		tp++;
		if(pp == m)
			matches.push_back(tp - m);	
	}
	return matches;
}

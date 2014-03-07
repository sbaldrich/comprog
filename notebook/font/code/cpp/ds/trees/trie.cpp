int n; //How many nodes do we have so far?
struct Trie{
	int words, prefix;
	int e[26]; //links to nodes by characters of the alphabet
	Trie():words(0),prefix(0){memset(this->e, 0, 26*sizeof(int));}
};

Trie tree[1048576]; //Why 2^20? Why not?

void add(Trie &t, const string &word, int index = 0){
	if(index == word.size())
		t.words++,t.prefix++;
	else{
		t.prefix++;
		int k = word[index] - 'a';
		if(t.e[k] == 0){
			t.e[k] = ++n;
			tree[n] = Trie();
		}
		add(tree[t.e[k]], word, index+1);
	}
}

bool present(const Trie &t, const string &w, int index=0){
	if(index == w.size())
		return t.words;
	int k = w[index] - 'a';
	if(!t.e[k])
		return false;
	return present(tree[t.e[k]], w, index+1);
}

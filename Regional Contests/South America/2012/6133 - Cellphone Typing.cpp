#include<cstdio>
#include<string>
#include<iostream>
#include<cstring>
#include<iomanip>
#include<vector>

using namespace std;

int n;
struct Trie{
	int words, prefix;
	int e[26];
	Trie():words(0),prefix(0){memset(this->e, 0, 26*sizeof(int));}
};

Trie tree[1048576];

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

int strokes(const Trie &t, const string &word, int index=0, int q = 0){
	if(index == word.size())
		return q;
	int k = word[index] - 'a';
	if(t.prefix == tree[t.e[k]].prefix){
		return strokes(tree[t.e[k]], word, index+1, q);
	}
	else{
		return strokes(tree[t.e[k]], word, index+1, q+1);
	}
}
void init(int L){
	for(int i=0;i<L;i++)
		tree[i] = Trie();
}
int main(){
	freopen("cell.in", "r" , stdin);
	static Trie t;
	int z;
	while(cin>>z){
		n = 0;
		memset(t.e,0,sizeof(int) * 26);
		init(z);
		vector<string> w(z);
		for(int i=0;i<z;i++){
			cin>>w[i];
			add(t,w[i]);
		}

		int ans = 0;
		for(int i=0;i<w.size();i++)
			ans += strokes(t,w[i]);
		cout << fixed << setprecision(2) << ans/(double)z<<endl;
	}
	return 0;


}


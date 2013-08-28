#include<iostream>
#include<queue>
#include<string>
#include<cstdio>

using namespace std;

struct Node{
	int id,freq,parent;
	bool operator<(const Node &n) const{
		return this->freq > n.freq;
	}
	Node(){id = freq = parent = 0;}
	friend ostream& operator<<(ostream &o, const Node &n){
		o << "[" << (n.id) << ", " << (n.freq) << "]";
	} 
};

int main(){

	freopen("p10.in", "r", stdin);

	string str;
	while(cin>>str && str!="END"){
		Node node[100];
		for(int i=0;i<str.size();i++){
			int x = str[i] == '_' ? 26 : str[i] - 'A';
			node[x].freq++;
			node[x].id = node[x].parent = x;
		}
		priority_queue<Node> Q;
		for(int i=0;i<27;i++){
			if(node[i].freq)
				Q.push(node[i]);
		}
	
		if(Q.size() == 1){
			printf("%d %d %.1f\n", str.size() * 8, str.size(), 8.0);
			continue;
		}
		
		int n = 27;
		
		while(Q.size() > 1){
			Node u,v;
			u = Q.top();
			Q.pop();
			v = Q.top(); 
			Q.pop();
			//cout << "u: " << u << " v: " << v << endl;
			node[n].freq = u.freq + v.freq;
			node[n].id = node[n].parent = n;
			node[u.id].parent = node[v.id].parent = n; 
			Q.push(node[n++]);
		}

		//cout << "end q" << endl;
		int ans = 0;

		for(int i=0;i<27;i++){
			if(node[i].freq){
				int depth = 0;
				Node u = node[i];
				while(u.parent != u.id){
					u = node[u.parent];
					depth++;
				}
				ans+=node[i].freq * depth;
			}
		}

		printf("%d %d %.1f\n" , 8 * str.size(), ans, 8.0 * str.size() / ans);
	}
	return 0;
}

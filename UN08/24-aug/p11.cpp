#include<iostream>
#include<vector>
#include<map>
#include<cstdio>
#include<set> 

using namespace std;

#define pb push_back
#define contains(c,x) (c.find(x)!=c.end())
#define fs first
#define sc second

typedef map<int, vector<int> > graph;
typedef vector<int> vi;

void print(graph &g){
	graph :: iterator it = g.begin();
	while(it!=g.end()){
		cout << it -> fs << ": ";
		vi &v = it->sc;
		for(int i=0;i<v.size();i++)
			cout << v[i] << " ";
		cout << endl;
		it++;
	}

}

set<int> visit;

void dfs(graph &g, int p){
	//printf("dfs(%d)\n", p);
	if(contains(visit,p))
		return;
	visit.insert(p);
	for(int i=0;i<g[p].size();i++){
		dfs(g,g[p][i]);
	}
}

int main(){
	freopen("p11.in" , "r", stdin);
	int p,q,tc=1;
	graph G;
	bool spf = false;
	bool line = false;
	while(cin>>p &&p){
		cin>>q;
		G = map<int, vector<int> >();
		if(line)
			printf("\n");
		G[p] = vi();
		G[p].pb(q);
		G[q] = vi();
		G[q].pb(p);
		while(cin>>p && p){
			cin>>q;
			if(!contains(G,p))
				G[p] = vi();
			if(!contains(G,q))
				G[q] = vi();
			G[p].pb(q);
			G[q].pb(p);
		}
		int n = G.size();
		printf("Network #%d\n", tc++);
		spf = false;
		//print(G);
		for(graph::iterator it = G.begin(); it!= G.end(); it++){
			visit.clear();
			visit.insert(it->fs);
			int comp = 0;
			for(graph::iterator it2 = G.begin();it2!=G.end(); it2++){
				//printf("from %d\n", it2->fs);
				if(it->fs == it2->fs)
					continue;
				//printf("%d cont\n", it2->fs); 
				//printf("ok");
				int test = it2->fs;
				//printf("%d -> %d\n" , it2->fs, contains(visit, test));
				if(!contains(visit,it2->fs)){
					dfs(G,it2->fs);
					comp++;
				}
				//for(int k=1;k<n;k++)
				//		cout <<visit[i] << " ";
			    //	cout << endl;
				
			}
			if(comp>1){
				if(spf)
					printf("\n");
				printf("  SPF node %d leaves %d subnets", it->fs, comp);
				spf = true;
			}
		}
		if(!spf)
			printf("  No SPF nodes");
		printf("\n");
		line = true;
	}
}

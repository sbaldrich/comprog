const int NN = 101;

typedef vector< vector <int> > graph;

int low[NN], disc[NN], parent[NN], dtime = 0;
bool visit[NN], ap[NN];

void dfs(const graph &g, int x){
	low[x] = disc[x] = ++dtime;
	visit[x] = true;
	int children = 0;
	for(int i=0;i < g[x].size(); i++){
		const int &y = g[x][i];
		if(!visit[y]){
			parent[y] = x;
			children++;
			dfs(g,y);
			low[x] = min(low[x], low[y]);
			if(parent[x] < 0 && children > 1)
				ap[x] = true;
			if(parent[x] >= 0 && low[y] >= disc[x])
				ap[x] = true;
		}
		else if(y != parent[x]){
			low[x] = min(low[x], disc[y]);
		}
	}
	
}

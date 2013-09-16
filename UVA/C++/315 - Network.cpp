#include<iostream>
#include<sstream>
#include<string>
#include<vector>
#include<cstring>

#define min(a,b) (a) < (b)? (a) : (b)

using namespace std;

typedef vector< vector <int> > graph;

const int NN = 101;

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

int main(){
	freopen("315.in", "r", stdin);
	string line;
	for(int n; cin >> n && n;){
		memset(low, -1, sizeof(int)*n);
		memset(disc, -1, sizeof(int)*n);
		memset(visit, false, sizeof(bool)*n);
		memset(ap, false, sizeof(bool)*n);
		memset(parent, -1, sizeof(int)*n);
		dtime = 0;	
		graph g(n , vector<int>());
		while(getline(cin,line)){
			if(line[0] == '0')
				break;
			stringstream ss(line);
			int v,x; 
			ss >> v;
			while(ss >> x)
				g[v-1].push_back(x-1),g[x-1].push_back(v-1);
		}
		dfs(g,0);
		int ans = 0;
		for(int i=0;i<n;i++)
			if(ap[i])
				++ans;
		cout << ans << endl;
	}
	return 0;
}

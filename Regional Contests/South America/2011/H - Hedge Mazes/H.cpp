/*
 * Created on: Mar 6, 2012
 * Author: sbaldrich
 * Problem H - Hedge Mazes
 * Source: Latin America Regional contest 2011
 *
 * In the official competition, Floyd warshall was enough to get AC in this problem. Yet with a normal time limit
 * this approach gets TLE. In order to solve it fast enough, one must see that the question is if a path between
 * two nodes is composed only by bridges. So, in short, if two nodes are connected on the graph without its non-bridge
 * edges they're a good challenge. To avoid having to traverse the graph after getting all bridges, disjoint sets are used.
 *
 * Thanks to ajmarin.
 */


#include <cstdio>
#include <cstring>
#include <vector>

using namespace std;

int r,cnt;
const int N = 10010;

vector<int> g[N];
int p[N] , born[N] , low[N];

int root(int x){ return p[x] == x?x:p[x] = root(p[x]);}
void union_find(int x , int y)
{
	p[root(x)] = root(y);
}

void dfs(int u , int parent = -1)
{
	low[u] = born[u] = cnt++;
	for(int i=0;i<(int)g[u].size();i++)
	{
		int v = g[u][i];
		if(born[v] == -1)
		{
			dfs(v, u);
			low[u] = min(low[u] , low[v]);
			if(low[v] == born[v])
				union_find(u,v);
		}
		else if(v != parent)
			low[u] = min(low[u] , born[v]);
	}
}

void bridges()
{
	memset(born , -1, sizeof(born));
	for(int i=0;i<r;i++)
		if(born[i] == -1)
			cnt = 0 , dfs(i);
}

int main()
{
	//freopen("H.in" , "r" , stdin);
	for(int c, q; scanf("%d %d %d" , &r, &c , &q) == 3 && r;)
	{
		for(int i=0;i<r;i++)
		{
			p[i] = i;
			g[i].clear();
		}
		for(int i=0,x,y;i<c;i++)
		{
			scanf("%d %d" , &x, &y);
			x--,y--;
			g[x].push_back(y);
			g[y].push_back(x);
		}
		bridges();
		for(int i=0,x,y;i<q;i++)
		{
			scanf("%d %d" , &x,&y);
			puts(root(--x) == root(--y) ? "Y" : "N");
		}
		puts("-");
	}
	return 0;
}

#include<iostream>
#include<cstring>

using namespace std;

#define abs(a) (a) < 0? -1*(a) : (a)
const int NN = 131072;
int p[NN];
int parent[NN];
int cycle_size[NN]; 
int cycle_label[NN]; //Label of node in its cycle (If it belongs to any)
bool visit[NN];
int L[NN]; //Level of node in a dfs for LCA
int P[NN][17]; //Sparse table for LCA

int root(int x){ return p[x] == x? x : p[x] = root(p[x]);}
int union_find(int a, int b){
	p[root(a)] = b = root(b);
	return a != b;
}

int level(int node){
	if(cycle_size[node])
		return L[node] = 0;
	if(L[node] != -1)
		return L[node];
	return L[node] = level(parent[node]) +1;
}

int lca(int p, int q){
	if(L[p] < L[q])
		p ^= q ^= p ^= q;
	int lg = 1;
	for(;(1 << lg) <= L[p];lg++);
	--lg;
	for(int i=lg;i>=0;i--)
		if(L[p] - (1 << i) >= L[q])
			p = P[p][i];
	if(p == q) // We were querying the same branch
		return p;
	for(;lg>=0;lg--)
		if(P[p][lg] != -1 && P[q][lg] != P[p][lg])
			p = P[p][lg], q = P[q][lg];
	return P[p][0];
}

int cycle_parent(int node){
	while(!cycle_size[node])
		node = parent[node];
	return node;
}

int main(){
	//freopen("j.in" , "r" , stdin);
	//freopen("j.out", "w", stdout);
	for(int n,q,caseno=0;cin>>n;caseno++){
		int d,a,b;
		for(int i=0;i<n;i++)
			p[i] = i;
		memset(parent, -1, sizeof(int) * n);
		memset(cycle_size, 0, sizeof(int) * n);
		memset(cycle_label, -1, sizeof(int) * n);
		memset(visit, false, sizeof(bool) * n);
		memset(L, -1, sizeof(int) * n);
		memset(P, -1, sizeof(int) * n);
		for(int i=0;i<n;i++){
			cin>>d,--d;
			if(!union_find(i,d)){ 
				int sz = 1,t,l=1;
				
				t = parent[d];
				do{
					++sz;
					t = parent[t];
				
				}while(t!=-1);
				
				t = d;
				
				do{
					cycle_label[t] = l++;
					cycle_size[t] = sz;
					t = parent[t];
				}while(t!=-1);
			
			}else{
				parent[i] = d;
			}
		}
		for(int i=0;i<n;i++)
			level(i);

		for(int i=0; i<n; i++){
			for(int j=0; 1 << j <n; j++)
				P[i][j] = -1;
			if(!cycle_size[i])
				P[i][0] = parent[i];
		}	

		for(int j=1; (1 << j) < n;j++)
			for(int i=0;i<n;i++)
				if(P[i][j-1] != -1)
					P[i][j] = P[P[i][j-1]][j-1];
			
		cin>>q;
		for(int i=0;i<q;i++){
			cin>>a>>b;
			--a,--b;
			if(root(a) != root(b))
				cout << -1 << endl;
			else{
				int ca = lca(a,b);
				if(ca == -1){
					int pa = cycle_parent(a), pb = cycle_parent(b);
					d = abs(cycle_label[pa] - cycle_label[pb]);
					cout << L[a] + L[b] + min(d, cycle_size[pa] - d);
				}
				else{
					cout << L[a] + L[b] - 2*L[ca];
				}
				cout << endl;
			}
		}
	}
	return 0;
}

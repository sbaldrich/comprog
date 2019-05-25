#include<bits/stdc++.h>

#define MAX_N 100010
using namespace std;

vector<int> g[MAX_N];
bool cat[MAX_N];
int n, m;

int dfs(int node, int cats, int parent){
    if(cat[node] && cats == m)  return 0;
    if(g[node].size() == 1 && parent > 0) return 1;
    int ans = 0;
    for(int i = 0; i < g[node].size(); i++){
        if(g[node][i] != parent){
            ans += dfs(g[node][i], cat[node] ? cats + 1 : 0, node);
        }
    }
    return ans;
}

int main(){
    std::ios::sync_with_stdio(false);
    cin >> n >> m;
    for(int i = 1; i <= n; i++) { cin >> cat[i];}
    for(int i = 1, u, v; i < n; i++){
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    cout << dfs(1, 0, 0) << endl;
    return 0;
}

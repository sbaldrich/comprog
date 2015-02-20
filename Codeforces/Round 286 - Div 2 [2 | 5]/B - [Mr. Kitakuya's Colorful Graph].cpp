#include<bits/stdc++.h>

#define D(x) cout << #x << ": " << x << endl
#define M 110
using namespace std;

int p[M][M];

int find( int u, int c ){
    return p[c][u] == u ? u : find(p[c][u], c);
}

void un( int u, int v, int c ){
    p[c][find(v,c)] = find(u, c); 
}

int main(){
    int n,m,q; cin >> n >> m;
    for( int i = 0; i < M; i++ )
        for( int j = 0; j < M; j++ )
            p[i][j] = j;
    for( int i = 0, u, v, c; i < m; i++ ){
        cin >> u >> v >> c;
        u--; v--;c--;
        un(u,v,c);
    }
    
    cin >> q;
    for( int i = 0, u, v; i < q; i++ ){
        cin >> u >> v;
        u--; v--;
        int ans = 0;
        for( int i = 0; i < M; i++ )
            ans += find(u,i) == find(v,i);
        cout << ans << endl;
    }
    return 0;
}
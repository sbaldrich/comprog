#include<iostream>
#include<queue>
#include<utility>
#include<cstring>
#include<iomanip>
using namespace std;

typedef pair<int,int> state;

#define state(x,y) make_pair(x,y)
#define fs first
#define sc second

int M,N;
const int NN=1024;

bool visit[NN][NN];
int pond[NN][NN];

bool ok(int r,int c){
	return r < M && c < N && r >= 0 && c >= 0 && !visit[r][c];
}

bool test(int x, int y){
	return x & y;
}

void set(int &x, int y){
	x |= y;
}
void bfs(int sr, int sc){
	queue<state> q;
	q.push(state(sr,sc));
	while(!q.empty()){
		state front = q.front();
		q.pop();
		int ar = front.fs , ac = front.sc;
		visit[ar][ac] = true;
		if(ok(ar-1,ac) && !test(pond[ar-1][ac],2))
			q.push(state(ar-1, ac));
		if(ok(ar,ac+1) && !test(pond[ar][ac+1], 1))
			q.push(state(ar, ac+1));
		if(ok(ar+1,ac) && !test(pond[ar][ac], 2))
			q.push(state(ar+1,ac));
		if(ok(ar,ac-1) && !test(pond[ar][ac],1))
			q.push(state(ar,ac-1));
	}
}

int main(){
	//freopen("F.in" , "r", stdin);
	for(int n; cin>>n;){
		M = 2*n; N = 2*n+1;
		memset(pond,0,sizeof(int) * NN * NN);
		memset(visit,false,sizeof(bool) * NN * NN);
		char c;
		for(int i=1;i<2*n;i++){
			for(int j=1;j<=n;j++){
				cin>>c;
				if(i&1){
					if(c == 'V'){
						set(pond[i-1][2*j-1],1);
						set(pond[i][2*j - 1],1);
					}else{
						set(pond[i-1][2*j-2],2);
						set(pond[i-1][2*j-1],2);
					}
				}else{
					if(c == 'V'){
						set(pond[i-1][2*j],1);
						set(pond[i][2*j],1);
					}else{
						set(pond[i-1][2*j],2);
						set(pond[i-1][2*j-1],2);
					}
				}
			}
		}
		int ans = -1;
		for(int i=0;i<2*n;i++)
			for(int j=0;j<2*n+1;j++)
				if(!visit[i][j]){
					ans++;
					bfs(i,j);	
				}
		cout << ans << endl;
	}
	return 0;
}



#include<iostream>
#include<queue>
#include<utility>
#include<algorithm>
#include<cstring>
#include<string>

using namespace std;

int M,N;

int block[55][55];
bool visit[55][55][4];

int dr[] = {-1,0,1,0};
int dc[] = {0,1,0,-1};

bool ok(int r, int c){
	if(r<=0 || r>=M || c<=0 || c>=N) return false;
	//cout << "ok " << r << ", " << c << endl;
	if( block[r-1][c-1] ||
		block[r-1][c]   ||
		block[r][c-1]   ||
		block[r][c])
			return false;
	return true;
}

struct state{
	int r,c,d,time;
	state(int r, int c, int d, int time): r(r), c(c), d(d), time(time) {}
};

ostream& operator<<(ostream &o, state &s){
	return o << "[state] " << s.r << " " << s.c << " " << s.d << " " << s.time;
}

void print(int M,int N){
	for(int i=0;i<M;i++){
		for(int i2=0;i2<N;i2++)
			cout << block[i][i2];
		cout << endl;
	}
}

int bfs(const int &start_r, const int &start_c, const int &end_r, const int &end_c, const int &dir){
	queue<state> Q;
	Q.push(state(start_r,start_c,dir,0));
	while(!Q.empty()){
		state top = Q.front();
		Q.pop();
		cout << "top: " << top << endl;	
		if(top.r == end_r && top.c == end_c)
			return top.time;
		
		visit[top.r][top.c][top.d] = true;
		
		if(!visit[top.r][top.c][(top.d + 1) % 4]){
			visit[top.r][top.c][(top.d + 1) % 4] = true;
			Q.push(state(top.r,top.c,(top.d + 1) % 4, top.time + 1));
		}

		if(!visit[top.r][top.c][(top.d + 3) % 4]){
			visit[top.r][top.c][(top.d + 3) % 4] = true;
			Q.push(state(top.r,top.c,(top.d + 3) % 4, top.time + 1));
		}

		for(int i=1;i<=3;i++){
			if(ok(top.r + dr[top.d] * i,top.c + dc[top.d] * i)){
				//cout << i << " ok" << endl;
				if(visit[top.r + dr[top.d] * i][top.c + dc[top.d] * i][top.d]) continue;
				visit[top.r + dr[top.d] * i][top.c + dc[top.d] * i][top.d] = true;
				Q.push(state(top.r + dr[top.d] * i, top.c + dc[top.d] * i , top.d, top.time+1));
			}
		}
	}
	return -1;
}

int main(){
	int start_r,start_c,end_r,end_c,dir;
	string x;
	freopen("input.txt", "r", stdin);
	while(cin>>M>>N && M && N){
		memset(visit,sizeof(visit[0][0][0] * 55 * 55 * 4) , false);
		for(int i=0;i<M;i++){
			for(int i2=0;i2<N;i2++)
				cin >> block[i][i2];
		}
		cin>>start_r>>start_c>>end_r>>end_c>>x;
		if(x[0] == 'n') dir = 0;
		else if(x[0] == 'e') dir = 1;
		else if(x[0] == 's') dir = 2;
		else dir = 3;

		cout << bfs(start_r,start_c,end_r,end_c,dir) << endl;
	}
	return 0;
}

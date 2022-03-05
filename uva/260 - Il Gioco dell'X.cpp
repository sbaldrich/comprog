#include<iostream>
#include<queue>
#include<utility>

#define M 210
#define pii pair<int,int>
#define fs first
#define sc second

using namespace std;

int dr[] = {-1,-1,0,0,1,1}, dc[]={-1,0,-1,1,0,1};
char board[M+1][M+1];

void print(int N){
	for(int i=0;i<=N+1;i++){
		for(int i2=0;i2<=N+1;i2++)
			cout<<board[i][i2];
		cout << endl;
	}
}


int main(){
	int N,tc = 1;
	bool black = false;
	while(cin>>N && N){
		queue< pii > Q;
		for(int i=0;i<=N+1;i++)
			board[0][i] = board[N+1][i] = board[i][0] = board[i][N+1] = 'x';
		for(int i=1;i<=N;i++){
			for(int i2=1;i2<=N;i2++)
				cin>>board[i][i2];
		}
		black = false;
		for(int i=1;i<=N;i++)
			if(board[1][i] == 'b'){
				Q.push(pii(1,i));
				board[1][i] = '.';
			}
			while(!Q.empty()){
				pii top = Q.front();	
				Q.pop();
				if(top.fs == N){
					black = true;
					break;
				}
				for(int i=0;i<6;i++){
					char& ref= board[top.fs + dr[i]][top.sc + dc[i]];
					if( ref == 'b')
						Q.push(pii(top.fs+dr[i], top.sc + dc[i])), ref= '.';
				}
			}
			cout << tc++ <<" "<<(black?"B":"W") << endl;
	}
	return 0;
}

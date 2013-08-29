#include<iostream>
#include<cstring>
#include<cstdio>

using namespace std;

int field[102][102];
bool visit[102][102];
int dr[] = {0,1,0,-1};
:q
int dc[] = {1,0,-1,0};

int area;

void init(){
	memset(visit,false,sizeof(bool) * 102 * 102);
	memset(field, 0, sizeof(int) * 102 * 102);
	area = 102*102;		
}

void dir(const char &w , int &r , int &c){
	c = r = 0;
	if(w == 'N')
		r++;
	if(w == 'S')
		r--;
	if(w == 'E')
		c++;
	if(w == 'W')
		c--;
}

bool ok(int r, int c){
	return r>=0 && c>=0 && c <= 101 && r <= 101;
}

void fill(int r, int c){
	if(!ok(r,c) || visit[r][c])
		return;
	
	area--;
	visit[r][c] = true;
	
	if( (field[r][c] & 1) == 0)
		fill(r,c+1);
	if( c > 0 && (field[r][c-1] & 1 ) == 0)
		fill(r, c-1);
	if( r > 0 &&(field[r-1][c] & 2) == 0)
		fill(r-1,c);
	if( (field[r][c] & 2) == 0)
		fill(r+1,c);
		
	field[r][c] = 8;
}

void print();
int main(){
	//freopen("2875.in" , "r" , stdin);

	int dsets;
	cin>>dsets;
	for(int tc=1;tc<=dsets;tc++){
		init();
		int cr,cc,st,moves,r,c;
		char d;
		cin>> cr >> cc >> moves;
		cr++, cc++;
		while(moves--){
			cin>> d >> st; 
			dir(d,r,c);
			for(int i=1;i<=st;i++){
				if(d == 'N') 
					field[cr][cc-1] |= 1;
				if(d == 'S')
					field[cr-1][cc-1] |= 1;
				if(d == 'E')
					field[cr-1][cc] |= 2;
				if(d == 'W')
					field[cr-1][cc-1] |=2;
				cr += r;
				cc += c;
			}
		}
		fill(0 , 0);
		//print();
		printf("Data Set %d: %d square feet.\n", tc, area); 
	}
	printf("End of Output\n");

	return 0;
}

void print(){
	for(int i=0;i<10;i++){
		for(int i2=0;i2<10;i2++)
			cout << field[i][i2];
		cout << endl;
	}
		
}

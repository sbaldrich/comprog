#include<vector>
#include<iostream>
#include<cmath>
#include<sstream>
#include<cstdio>

using namespace std;

#define fi(i, n) for(int i=0;i<n;i++)

typedef vector< vector <int> > vvi;

int idx;
stringstream output;

void encode(const vvi &m, int rs, int re, int cs, int ce){
	if(rs >= m.size() || cs >= m[0].size())
		return;
	//printf("f(%d,%d,%d,%d)\n", rs,re,cs,ce);
	bool done = true;
	for(int i=rs;i<=re;i++)
		for(int j=cs; j<=ce; j++)
			done &= (m[i][j] == m[rs][cs]);
	if(done){
		output << m[rs][cs];
		return;
	}
	else{
		output << "D";
		int nr , nc, dr, dc;
		nr = (re - rs) + 1;
		nc = (ce - cs) + 1;
		
		dr = nr/2;
		dc = nc/2;
		
		if(nr % 2)
			dr++;
		if(nc % 2)
			dc++;
	
		dr--;dc--;
		//printf("%d %d\n", nr,nc);
		encode(m, rs, rs + dr, cs, cs + dc);
		encode(m, rs, rs + dr, cs + dc + 1, ce);
		encode(m, rs + dr + 1, re, cs, cs + dc);
		encode(m, rs + dr + 1, re, cs + dc + 1, ce);
	}
}

void decode(vvi &m, const string &s, const int rs, const int re, const int cs, const int ce){
	if(re < rs || ce < cs)
		return;
	//printf("d(%d,%d,%d,%d,%d)\n", idx, rs,re,cs,ce);
	if(s[idx] == 'D'){
		idx++;
		int nr , nc, dr, dc;
		nr = (re - rs) + 1;
		nc = (ce - cs) + 1;
		
		dr = nr/2;
		dc = nc/2;
	
		if(nr % 2)
			dr++;
		if(nc % 2)
			dc++;
		dc--;dr--;	

		//printf("%d %d\n", dr,dc);
		//printf("%d %d\n", nr,nc);
		decode(m, s, rs, rs + dr, cs, cs + dc);
		decode(m, s, rs, rs + dr, cs + dc + 1, ce);
		decode(m, s, rs + dr + 1, re, cs, cs + dc);
		decode(m, s, rs + dr + 1, re, cs + dc + 1, ce);
		
	}
	else{
		//printf("s[%d] = %c\n" , idx, s[idx]);
		for(int i=rs;i<=re;i++)
			for(int j=cs;j<=ce;j++)
				m[i][j] = s[idx] - '0';
		idx++;
	}
}

void shittyformat(const string &s){
	int i,j;
	for(i=0,j=0;i<s.size();i++,j++){
		cout << s[i];
		if(j == 49){
			j = 0;
			cout << endl;
		}
	}
	if(j)
		cout <<endl;
}

int main(){
	
	//freopen("p5.in" , "r" , stdin);

	char t;
	int m, n;
	string line, aux;
	bool r1 = true;
	while(1){
		if(r1)
			cin>>t;
		else {
			t = aux[0];
			r1 = true;
		}
		cin>>m>>n;
		if(t=='#')
			break;
		output.str("");
		output.clear();
		if(t == 'B'){
			vvi mat(m, vector<int>(n));
			fi(i,m)
				fi(i2,n){
					cin>>t;
					mat[i][i2] = t-'0';
				}
			printf("D%4d%4d\n", m,n);
			encode(mat, 0, m-1, 0, n-1);
		}
		else{
			vvi mat(m, vector<int> (n));
			while(cin>>aux && aux.size() > 1){
				line+=aux;
			}
			r1 = false;
			decode(mat, line, 0, m-1, 0, n-1);
			printf("B%4d%4d\n", m,n);
			fi(i,m)
				fi(j,n)
					output << mat[i][j];
		}
		shittyformat(output.str());
	}
}

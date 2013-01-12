#include<iostream>
#include<cstdio>

#define min(a,b) (a) < (b) ? (a) : (b)  

using namespace std;

int m2[1001][1001], m5[1001][1001];
char d2[1001][1001], d5[1001][1001];
const int oo = 0x3f3f3f3f;


void path(int i , int j, char d[1001][1001])
{
	if(!i && !j)
		return;
	if(d[i][j] == 'D')
		path(i-1,j, d);
	if(d[i][j] == 'R')
		path(i,j-1, d);
	printf("%c", d[i][j]);
}


int main()
{
	int n, zi=-1, zj=-1, a2, a5,v;
	freopen("b.in", "r", stdin);
	scanf("%d" , &n);
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			a2 = a5 = oo; 
			scanf("%d" , &v);
			if(!v)
				zi = i , zj = j;
			else{
				while(!(v & 1)) ++m2[i][j], v>>=1;
				while(!(v % 5)) ++m5[i][j], v/=5;
			}
			if(!i && !j) continue;
			if(i)
			{
				a2 = m2[i-1][j];
				a5 = m5[i-1][j];
				d2[i][j] = d5[i][j] = 'D'; 
			}
			if(j)
			{
				if(m2[i][j-1] < a2) a2 = m2[i][j-1], d2[i][j] = 'R';
				if(m5[i][j-1] < a5) a5 = m5[i][j-1], d5[i][j] = 'R';
			}
			m2[i][j]+=a2;	
			m5[i][j]+=a5;	
		}
	}
	//printf("2: %d , 5: %d\n", m2[n-1][n-1], m5[n-1][n-1]);	
	int ans = min(m2[n-1][n-1], m5[n-1][n-1]);
	if(zi != -1 && ans > 1)
	{
		printf("1\n");
		path(zi, zj, d2);
		for(int i=zi+1;i<n;i++)printf("D");
		for(int i=zj+1;i<n;i++)printf("R");
		return 0;
	} 
	printf("%d\n" , ans);
	if(ans == d2[n-1][n-1])
		path(n-1,n-1,d2);
	else path(n-1,n-1,d5);
	printf("\n");
	return 0;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			printf("%3d%s", m2[i][j] , j==n-1?"\n":" ");
	printf("\n "); 	
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			printf("%3c%s", d2[i][j] , j==n-1?"\n":" "); 	
	printf("\n\n");	
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			printf("%3d%s", m5[i][j] , j==n-1?"\n":" ");
	printf("\n "); 	
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			printf("%3c%s", d5[i][j] , j==n-1?"\n":" "); 	
	cout << ans << endl;
	return 0;
}

#include<iostream>
#include<string>

using namespace std;

int m, n;
int dr[] = {-1,-1,-1,0,1,1,1,0};
int dc[] = {-1,0,1,1,1,0,-1,-1};

char M[110][110];

void dfs(int r , int c)
{
	if(r<=0 || c<=0 || c>n || r>m)
		return;
	if(M[r][c] == '*')
		return;
	M[r][c] = '*';
	for(int i=0;i<8;i++)
	{
		if(M[r+dr[i]][c+dc[i]]=='@')
			dfs(r+dr[i],c+dc[i]);
	}
	return;
}

void print()
{
	cout << endl;
	for(int i=0;i<=m+1;i++)
		for(int j=0;j<=n+1;j++)
			cout << M[i][j] << (j<n+1?" ":"\n");
	cout << endl <<endl;
}

int main()
{
	//freopen("572.in" , "r" , stdin);
	while(cin>>m>>n &&n && m)
	{
		int ans=0;
		memset(M,'*',sizeof(M));
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
				cin>>M[i][j];
		//cout << "Initial "<<endl;
		//print();
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
				if(M[i][j]=='@')
					dfs(i,j) , ans++;// , print();
		cout << ans << endl;
	}
	return 0;
}





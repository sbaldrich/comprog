#include<cstdio>
#include<cstring>

#define N 110
//Watch out, this is defined from 1 to n due to the nature of the problem
#define fi(i,n) for(int i=1;i<=n;i++)

char field[N][N];

int dr[] = {0,-1,-1,-1,0,1,1,1};
int dc[] = {-1,-1,0,1,1,1,0,-1};

void print_field(int rows=N, int cols=N)
{
	fi(i,rows)
	{
		fi(j,cols)
			printf("%c",field[i][j]);
		printf("\n");
	}
}


int main()
{
	//freopen("test.in" , "r", stdin);
	int R,C,test = 1;
	char x;
	while(scanf("%d %d\n" , &R, &C) > 0)
	{	
		if(!R || !C)
			break;
		if(test>1)
			printf("\n");
		memset(field, '0', sizeof(field[0][0]) * N * N);
		fi(i,R)
		{
			fi(j,C)
			{
				scanf("%c", &x);
				if(x == '*')
				{
					for(int k=0;k<8;k++)
					{
						char& ref = field[i+dr[k]][j+dc[k]];
						if(ref != '*')
							ref++;
					}
					field[i][j] = x;
				}
			}
			scanf("\n");
		}
		printf("Field #%d:\n", test++);		
		print_field(R,C);
	}
}



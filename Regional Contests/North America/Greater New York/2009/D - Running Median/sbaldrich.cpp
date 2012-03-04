/*
 * Created on: 09/11/2011
 * Author: sbaldrich
 * Problem: Running Median
 * Source: Greater New York 2009
 */

#include<algorithm>
#include<vector>
#include<cstdio>
#include<iostream>
#include<cmath>
#include<cstring>

using namespace std;

#define min(a,b) (a)<(b)?(a):(b)
#define max(a,b) (a)>(b)?(a):(b)

const int oo = 0x7FFFFFFF;
const int MAX_NUMS = 1000000;

int main()
{
	//freopen("D.in" , "r" , stdin);
	vector<int> X(MAX_NUMS,0),V;
	int pt = MAX_NUMS/2;
	int P,c,M,x,L,R;
	scanf("%d",&P);
	for(int z=0;z<P;z++)
	{
		V = X;
		scanf("%d %d" , &c , &M);
		bool flag = false;
		printf("%d %d\n", c, (M+1)/2);
		L=oo,R=-oo;
		for(int i=1;i<=M;i++)
		{
			scanf("%d",&x);
			L = min(L,x);
			R = max(R,x);
			V[pt + x]++;
			if(i%2!=0)
			{
				x = i/2 +1;
				int ind;
				for(ind=L;x>0;ind++)
					x-=V[pt+ind];
				printf("%d",ind-1);
				if((2*i+2)%10 == 0)
				{
					if(flag)
					{
						cout << endl,flag=false;
						continue;
					}
					else flag = true;
				}
				if(i/2 < (M+1)/2 - 1)
					printf(" ");


			}
		}
		printf("\n");
	}
	return 0;
}


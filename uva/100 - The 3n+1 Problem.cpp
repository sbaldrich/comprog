#include<cstdio>

int f(int x)
{
	if(x <= 1)
		return 1;
	if(x%2 == 0)
		return 1 + f(x/2);
	else
		return 1 + f(3*x + 1);
}

int main()
{
//	freopen("100.in", "r", stdin);
	int i, j, ans = -1, l, r, x;
	while(scanf("%d %d" , &i, &j) > 0 ) 
	{
		ans = -1;
		l = i , r = j;
		if(i>j)
		{
			int t = j;
			j=i;
			i=t;
		}
		for(int k=i;k<=j;k++)
			if((x = f(k)) > ans)
				ans = x;
		printf("%d %d %d\n", l , r , ans);
	}
	return 0;
}

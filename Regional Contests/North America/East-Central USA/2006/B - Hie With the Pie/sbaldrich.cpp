/*
 * Created on: Jan 17, 2012
 * Problem B - Hie With the Pie
 * Author: sbaldrich
 *
 *	This is a reduced instance of the postman problem. Since there are only 10 nodes, we can try all posible
 *	permutations after getting the shortest/cheapest path between all pairs of nodes ( floyd-warshall ). Just
 *	update the answer each time you find a better one.
 *	O(n^3) for floyd + 10!=~ 3.7M for combinations.
 */

#include<iostream>
#include<algorithm>
#include<cstdio>
#include<vector>


using namespace std;

ostream& operator<<(ostream& o , vector<int> &v)
{
	for(int i=0;i<(int)v.size();i++)
		o << v[i]<<" ";
	return o;
}

int main()
{
	//freopen("B.in", "r" , stdin);
	int n,i,j,k;
	int d[12][12];
	int nums[] = {1,2,3,4,5,6,7,8,9,10};
	vector<int> A;
	while(cin>>n && n)
	{
		for(i=0;i<=n;i++)
			for(j=0;j<=n;j++)
				cin>>d[i][j];
		for(k=0;k<=n;k++)
			for(i=0;i<=n;i++)
				for(j=0;j<=n;j++)
					d[i][j] = min(d[i][j] , (d[i][k] + d[k][j]));

		A = vector<int>(nums,nums+n);
		int ans = 0x3FFFFFFF;
		do
		{
			int x = 0;
			x+=d[0][A[0]];
			for(int i=1;i<n;i++)
				x+=d[A[i-1]][A[i]];
			x+=d[A[n-1]][0];
			ans = min(ans, x);
		}
		while(next_permutation(A.begin(),A.end()));
		cout << ans << endl;
	}
	return 0;
}





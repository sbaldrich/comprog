/*
 * Created on: 07/11/2011
 * Author: sbaldrich
 * Problem: B - Equal Sum Partitions
 * Source: Greater New York 2009
 */

#include<iostream>
#include<vector>

using namespace std;

int main()
{
	//freopen("B.in" , "r" , stdin);
	int c, P , M;
	cin>>P;

	for(int z=0;z<P;z++)
	{
		cin>>c>>M;
		vector<int> V(M);
		for(int i=0;i<M;i++)
			cin>>V[i];

		int minSum = V[0] , end = 0,accum = 0;
		for(int i=end+1;i<M;i++)
		{
			accum+=V[i];
			if(accum > minSum)
			{
				end++,minSum+=V[end],i=end,accum=0;
			}
			if(accum == minSum)
				accum = 0;
		}
		cout <<c<<" "<< minSum+accum<<endl;

	}
	return 0;
}




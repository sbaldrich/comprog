/*
 *  Created on: Mar 18, 2012
 *      Author: sbaldrich
 */

#include<iostream>
#include<vector>
#include<cstdio>

using namespace std;

int main()
{
	int cases,n;
	vector<double>C;
	double a0 ,an1;
	cin>>cases;
	while(cases--)
	{
		cin>>n>>a0>>an1;
		C = vector<double>(n);
		for(int i=0;i<n;i++)
			cin>>C[i];
		double ans = n*a0 + an1;
		for(int i=n-1, j=2;i>=0;i--,j+=2)
			ans-= C[i] * j;
		printf("%.2f\n" , ans/(n+1));
		if(cases)
			printf("\n");
	}
	return 0;
}



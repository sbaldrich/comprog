/*
 * Created on: 08/11/2011
 * Author: sbaldrich
 * Problem: F - Adjacent Bit Count
 * Source: Greater New York 2009
 */

#include<iostream>

using namespace std;

int N[102][102] , N1[102][102] , N0[102][102];

int f0(int n,int k);
int f1(int n,int k);
int f (int n,int k);

int f(int n, int k)
{
	if(n<=k)
		return N[n][k] = 0;
	if(n<=0 || k<0)
		return 0;
	if(n==1 && k==0)
		return 1;
	if(N[n][k]>=0)
		return N[n][k];
	return N[n][k] = f0(n,k) + f1(n,k);
}

int f0(int n , int k)
{
	if(n==1 && k==0)
		return 1;
	if(N0[n][k]>=0)
		return N0[n][k];

	N0[n][k] = f0(n-1,k) + f1(n-1,k);
	return N0[n][k];
}

int f1(int n , int k)
{
	if(N1[n][k]>=0)
		return N1[n][k];


	if(n==1 && k==0)
		return N1[n][k] = 1;
	N1[n][k] = f0(n-1,k) + f1(n-1,k-1);

	return N1[n][k];
}
int main()
{
	//freopen("F.in" , "r" , stdin);
	for(int i=0;i<101;i++)
		for(int j=0;j<101;j++)
			N[i][j] = N0[i][j] = N1[i][j] = -1;


	int P,c,n,k;
	cin>>P;
	for(int z=0;z<P;z++)
	{
		cin>>c>>n>>k;
		cout <<c<<" "<<f(n,k)<<endl;
	}

	return 0;
}




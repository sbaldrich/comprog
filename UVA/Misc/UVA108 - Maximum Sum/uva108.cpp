#include<cstdio>
#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

#define oo 0x7FFFFFF3

ostream& operator<<(ostream& out , vector<int> v)
{
	int n = v.size();
	out << "[ ";
	for(int i=0;i<n-1;i++)
		out << v[i]<<", ";
	out << v[n-1]<<" ]";
	return out;

}

int kadane(vector<int> v)
{
	cout << v << endl;
	int msf = 0 , meh = 0;
	int  n = v.size();
	for(int i=0;i<n;i++)
	{
		meh = max(0, meh + v[i]);
		msf = max(msf, meh);
	}
	cout << msf << endl;
	return msf;
}

int main()
{

	freopen("uva108.in" , "r" , stdin);

	int n , M[200][200] , p[200][200];
	scanf("%d" , &n);
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			scanf("%d" , &M[i][j]);

	for(int j=0;j<n;j++)
		for(int i=0;i<n;i++)
				if(i == 0)
				   p[i][j] = M[i][j];
				else
				   p[i][j]  = M[i][j] + p[i-1][j];


	int best = -oo;
	vector<int> v(n);
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<i;j++)
		{
			for(int k=0 ;k<n;k++)
				v[k] = p[i][k] - p[j][k];
			cout << "Testing " << v << endl;
			best = max(best,kadane(v));
		}
	}
	printf("%d\n" , best);



	return 0;
}



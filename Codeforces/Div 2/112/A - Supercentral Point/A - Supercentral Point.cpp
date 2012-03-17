/*
 * Created on: Mar 16, 2012
 * Author: sbaldrich
 * Source : Codeforces Round 112 Div2 - A
 * Brute Force your way to the solution. Check if all four directions have been found
 * In this code I use a bitmask. O(n2)
 */

#include<vector>
#include<iostream>

using namespace std;

typedef vector<int> p;

int lct(p &a , p &b)
{
	if(b[1] == a[1])
	{
		if(b[0]<a[0])
			return 2;
		else if(b[0] > a[0])
			return 1;
	}
	else if(b[0] == a[0])
	{
		if(a[1] < b[1])
			return 3;
		else if(a[1] > b[1])
			return 4;
	}
	return 0;
}



int main()
{
	int ans = 0;
	int n ;
	cin>>n;
	vector< p > all;
	for(int i=0;i<n;i++)
	{
		p x(2);
		cin>>x[0]>>x[1];
		all.push_back(x);
	}
	for(int i=0;i<n;i++)
	{
		int x = 0;
		for(int j=0;j<n;j++)
		{
			if(i != j)
				x|=1<<lct(all[i] , all[j]);
		}
		if(x == 31 || x == 30)
			ans++;
	}
	cout << ans;
	return 0;
}



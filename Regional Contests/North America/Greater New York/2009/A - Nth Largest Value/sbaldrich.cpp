/*
 * Created on: 07/11/2011
 * Author: sbaldrich
 * Problem: A - Nth Largest Value
 * Source: Greater New York 2009
 */

#include<algorithm>
#include<vector>
#include<iostream>

using namespace std;

int main()
{
	//freopen("A.in" , "r" , stdin);
	int n , c;
	vector<int>V;
	cin>>n;
	for(int z=0;z<n;z++)
	{
		V = vector<int>(10,0);
		cin>>c;
		for(int i=0;i<10;i++)
			cin>>V[i];
		sort(V.begin(),V.end());
		V.resize(unique(V.begin(),V.end()) - V.begin());
		cout << c << " " << V[V.size()-3]<<endl;
	}
	return 0;
}




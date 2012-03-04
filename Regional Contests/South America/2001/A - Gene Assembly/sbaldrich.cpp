/*
 * Created on: Nov 2, 2011
 * Author: sbaldrich
 * Problem: Gene Assembly
 * Source: South America Regional Contest 2001
 */

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

#define min(a,b) (a)<(b)?(a):(b)
#define all(c) (c).begin(),(c).end()

struct exxon
{
	int a,b,pos;
	exxon(int x,int y,int p)
	{
		a = min(x,y);
		b = a==x?y:x;
		pos = p;
	}
	friend bool operator<(exxon A , exxon B)
	{
		if(A.a < B.a)
			return true;
		else if(A.a == B.a && A.b < B.b)
			return true;
		return false;
	}
	friend ostream& operator<<(ostream &o , exxon &e)
	{
		o<< "[ "<<e.a<<" , "<<e.b<<"Ê]";
		return o;
	}
};

template<class T>
ostream& operator<<(ostream& o , vector<T> v)
{
	int n = v.size();
	o<<"{ ";
	for(int i=0;i<n;i++)
		o<<v[i]<<(i<n-1?" ":"");
	o<<" }";
	return o;
}

void printpath(vector<int> &parent , vector<exxon> &V, int pos)
{
	if(parent[pos]!=-1)
		printpath(parent,V,parent[pos]);
	cout <<(parent[pos]!=-1?" ":"")<<V[pos].pos;
}

int main()
{
	//freopen("A.in" , "r" , stdin);
	int n,x,y;
	while(cin>>n &&n)
	{
		vector<exxon> V;
		vector<int> lis(n,0),parent(n,-1);
		for(int i=0;i<n;i++)
		{
			cin>>x>>y;
			V.push_back(exxon(x,y,i+1));
		}
		sort(all(V));
		for(int i=0;i<n;i++)
		{
			lis[i]=1;
			for(int j=0;j<i;j++)
			{
				if(V[j].b < V[i].a)
				{
					if(lis[i] < lis[j]+1)
					{
						lis[i] = lis[j]+1;
						parent[i] = j;
					}
				}
			}
		}
		printpath(parent , V , max_element(all(V)) - V.begin());
		cout << endl;
	}
	return 0;
}




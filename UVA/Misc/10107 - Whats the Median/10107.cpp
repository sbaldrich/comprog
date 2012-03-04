#include<iostream>
#include<algorithm>
#include<vector>


#define all(c)   (c).begin() , (c).end()

using namespace std;

ostream& operator<<(ostream& out , vector<int> v)
{
	int n = v.size();
	out << "[ ";
	for(int i=0;i<n;i++)
		out << v[i]<<(i<n-1?", ":" ]");
	return out;
}

int main()
{
	//freopen("10107.in" , "r" , stdin);

	int n , t=1;
	vector<int> V;

	while(cin>> n)
	{
		V.push_back(n);
		sort(all(V));
		//cout << t << " : "<<V<<endl;
		if(t == 1)
		{
			cout << V[0]<<endl,t++;
			continue;
		}
		if(t%2)
			cout << V[V.size()/2];
		else
		{
			cout << (V[V.size()/2 - 1] + V[V.size()/2 ]) / 2;
		}
		cout << endl , t++;
	}
	return 0;
}

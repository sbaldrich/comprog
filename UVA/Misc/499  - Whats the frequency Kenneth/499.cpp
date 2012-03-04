#include<iostream>
#include<string>
#include<map>
#include<utility>
#include<vector>
#include<algorithm>

using namespace std;



int main()
{

	//freopen("499.in" , "r" , stdin);

	string line , alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int m;
	map<char,int> M;
	while(getline(cin,line))
	{
		m = 0;
		M.clear();
		for(int i=0;i<(int)line.size();i++)
		{
			if(alpha.find(line[i])!=string::npos)
			{
				M[line[i]]++;
				if(M[line[i]]>m)
					m = M[line[i]];
			}
		}
		vector< pair<char,int> > V(M.begin(),M.end());
		sort(V.begin() ,V.end());
		//reverse(V.begin() ,V.end());
		for(int i=0;i<V.size();i++)
			if(V[i].second == m)
				cout << V[i].first;
		if(!V.empty())
			cout << " "<< m;
		cout << endl;
	}
	return 0;
}

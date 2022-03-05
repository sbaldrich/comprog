#include<iostream>
#include<vector>

using namespace std;

int main()
{
	//freopen("10327.in" , "r" ,stdin);

	int n,ans;
	while(cin>> n)
	{
		ans = 0;
		vector<int>v(n);
		for(int i=0;i<n;i++)
		{
			cin>>v[i];
			for(int j=0;j<i;j++)
				if(v[j]>v[i])
					ans++;
		}
		cout << "Minimum exchange operations : " <<ans <<endl;
	}
	return 0;
}

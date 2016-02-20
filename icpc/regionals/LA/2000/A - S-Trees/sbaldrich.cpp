#include<iostream>
#include<cmath>

using namespace std;

int main()
{
	int n, vva, pos[8], vals[8],t=1;
	string v , str,ans;

//	freopen("A.in" , "r" , stdin);

	while(cin>>n && n)
	{
		ans = "";
		for(int i=0;i<n;i++)
		{
			cin>>v;
			pos[v[1]-'0'-1] = i;
		}
		cin>>str>>vva;
		for(int i=0;i<vva;i++)
		{
			cin>>v;
			for(int j=0;j<n;j++)
			{
				vals[pos[j]] = v[j]-'0';
			}
			int index = 0;
			for(int j=0;j<n;j++)
			{
				index+=pow(2.0 , n-1-j)*vals[j];
			}
			ans+=str[index];
		}
		cout << "S-Tree #"<<t++<<endl<<ans<<endl<<endl;
	}
	return 0;
}

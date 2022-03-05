#include<iostream>
#include<string>

using namespace std;

string num = "0123456789";

bool isnum(char c)
{
	if(num.find(c)!=string::npos)
		return true;
	return false;
}

int main()
{
	//freopen("445.in" , "r" , stdin);
	string line;

	while(getline(cin,line))
	{
		int n = line.size(),t;
		char x;
		for(int i=0;i<n;i++)
		{
			t = 0;
			x = line[i];
			if(x=='!')
			{
				cout << endl;
				continue;
			}
			while(isnum(x))
				t+=x-'0',x=line[++i];
			for(int j=0;j<t;j++)
				cout << (x=='b'?' ':x);
		}
		cout<< endl;
	}
	return 0;
}




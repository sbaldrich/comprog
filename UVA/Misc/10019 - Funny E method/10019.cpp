#include<iostream>
#include<sstream>

using namespace std;

int main()
{
	int c,n;
	//freopen("10019.in" , "r" , stdin);
	cin>>c;
	while(c--)
	{
		cin>>n;
		cout << (__builtin_popcount(n))<<" ";
		stringstream oss;
		oss << n;
		oss >> hex >> n;
		cout << (__builtin_popcount(n))<< endl;
	}
	return 0;
}




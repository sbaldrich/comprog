#include<iostream>

using namespace std;

int main()
{
	//freopen("10812.in" , "r" ,stdin);
	long long t,a,b,x,y;
	cin>>t;
	while(t--)
	{
		cin>>a>>b;
		if(b<=a &&( (a%2 && b%2) || (!(a%2) && !(b%2))))
		{
			x = a/2+b/2 , y = a/2 - b/2;
			cout << (x>y?x:y)+(a%2?1:0) << " "<<(x<y?x:y);
		}
		else
			cout <<"impossible";
		cout << endl;
	}
	return 0;
}

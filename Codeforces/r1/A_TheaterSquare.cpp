#include<iostream>
#include<cmath>

using namespace std;

typedef long long i64;

int main()
{
	double n,m,x;
	while(cin>>n >> m >> x)
	{
		cout << (i64)(ceil(m/x) + ceil(m/x)*ceil((n/x) - 1)) << endl;		
	}
}


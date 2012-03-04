#include<iostream>
#include<cstdio>

using namespace std;

int main()
{
	unsigned long long  a , b;
	while((scanf("%llu %llu" , &a,&b)) == 2)
	{
		printf("%llu\n", (unsigned long long)(a^b));
	}
	return 0;
}



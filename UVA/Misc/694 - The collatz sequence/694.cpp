#include<iostream>
#include<map>

using namespace std;

map<long long,long long> memo;
int L;

long long f(long long n)
{
	if(n > L)
		return 0;
	if(n == 1)
		return 1;
	if(memo.count(n))
		return memo[n];
	if( n % 2 == 0)
		return memo[n] = f(n/2) + 1;
	else return memo[n] = f(3*n + 1) + 1;
}

int main()
{
	//freopen("694.in" , "r" , stdin);
	int A,c=1;
	while(cin>> A >> L && A>=0 && L>=0)
	{
		memo.clear(); // This isn't really doing something but I'm too lazy to erase it.
		cout <<"Case "<<c++<<": A = "<<A<<", limit = "<<L<<", number of terms = "<<f(A) << endl;
	}
	return 0;
}



#include<iostream>
#include<map>
#include<utility>

#define mp make_pair
using namespace std;

map<  pair<long long,long long>, long long >dp;


long long C(int n ,int k)
{
	if(dp.count(mp(n,k)))
		return dp[mp(n,k)];
	if(k == 0 || n == 1 || k == n)
		return 1;
	if(k == 1)
		return n;
	return dp[mp(n,k)] = C(n-1,k-1) + C(n-1,k);
}

int main()
{
	//freopen("530.in" , "r" , stdin);
	int n ,k;
	while(cin>>n>>k && n && k)
		cout << C(n,k)<<endl;
	return 0;
}





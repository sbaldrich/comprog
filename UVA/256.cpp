#include<iostream>
#include<vector>

using namespace std;

int a[]={0, 1, 81};
int b[]={0, 1, 2025, 3025, 9801};
int c[]={0, 1, 88209, 494209, 998001};
int d[]={0, 1, 4941729, 7441984, 24502500, 25502500, 52881984, 60481729, 99980001};

typedef vector<int> vi;

int main()
{
	int n;
	vector< vi > ans(9);
	ans[2] = vi(a,a+3);
	ans[4] = vi(b,b+5);
	ans[6] = vi(c,c+5);
	ans[8] = vi(d,d+9);
	while(cin>>n)
	{
		for(int i=0;i<ans[n].size();i++)
			cout.fill('0'),cout.width(n),cout<<ans[n][i]<<endl;
	}
	return 0;
}

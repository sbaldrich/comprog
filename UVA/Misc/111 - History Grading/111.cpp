#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int dp[30][30];
int n;
template<class T>
ostream& operator<<(ostream &out , vector<T> v)
{
	int n = v.size();
	out << "[ ";
	for(int i=0;i<n;i++)
		out << v[i]<<(i<n-1?", ":" ]");
	return out;
}

int lcs(vector<int> &a , vector<int> &b)
{
	for(int i=0;i<=n;i++)
		dp[i][0]=dp[0][i]=0;
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
			dp[i][j] = (a[i] == b[j]?dp[i-1][j-1] + 1 : max(dp[i-1][j] , dp[i][j-1]));
	}

	return dp[n][n];
}



int main()
{
	//freopen("111.in" , "r" , stdin);
	int d;
	cin>>n;
	vector<int> correct(n+1,0) , x(n+1,0);
	for(int i=1;i<=n;i++)
		cin>>d,correct[d] = i;
	//cout << "Correct: " <<endl<< correct << endl;
	while(cin>>d)
	{
		x[d] = 1;
		for(int j=2;j<=n;j++)
			cin>>d,x[d]=j;
		//cout << x << endl;
		cout << lcs(correct,x) << endl;
	}
	return 0;
}

/*
 *  Created on: Mar 18, 2012
 *      Author: sbaldrich
 */

#include<string>
#include<iostream>

using namespace std;
#define max(a, b) (a)>(b)?(a):(b)
string mat[30];
int main() {
	freopen("submatrix.in" , "r" , stdin);
	int cases,i,j,k,l,p,q;
	cin >> cases;
	while (cases--) {
		cin >> mat[0];
		int n = mat[0].size();
		for (i = 1; i < n; i++)
			cin >> mat[i];
		int ans = 0 ;
		for(i=0;i<=n;i++)
			for(j=0;j<=n;j++)
				for(k=i;k<=n;k++)
					for(l=j;l<=n;l++)
					{
						bool ok = true;
						for(p=i;p<k && ok;p++)
							for(q=j;q<l && ok;q++)
								if(mat[p][q]=='0')
									ok = false;
						if(ok)
							ans = max(ans , (k - i) * (l - j));
					}
		cout << ans;
		if(cases>0)
			cout << endl<<endl;
	}
	return 0;
}


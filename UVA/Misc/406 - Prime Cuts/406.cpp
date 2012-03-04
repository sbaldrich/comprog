#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;

#define all(c)	(c).begin() , (c).end()

int main()
{
	vector<int> primes;
	primes.push_back(1);
	primes.push_back(2);
	for(int i=3;i<1000;i++)
	{
		bool ok = true;
		for(int j=2;j*j<i+1;j++)
			if(i%j==0)
			{
				ok = false;
				break;
			}
		if(ok)
			primes.push_back(i);
	}

	int N,C;
	//freopen("406.in" , "r" , stdin);
	/*for(int i=0;i<50;i++)
		cout << primes[i]<<" ";
	cout << endl;*/
	while(cin>>N>>C)
	{
		int end = (*lower_bound(all(primes) ,N) == N? lower_bound(all(primes) ,N) - primes.begin() :
				lower_bound(all(primes) ,N) - 1 - primes.begin());

		/*cout << "N: "<<N << " end: " << end << endl;
		cout << N << " " << C<<": ";

		cout << "Full list is: "<<endl;

		for(int i=0;i<=end;i++)
			cout << primes[i]<<(i<end?" ":"");

		cout << endl << endl;
*/

		cout << N <<" "<<C<<": ";
		if(2*C > end+1)
			for(int i=0;i<=end;i++)
				cout << primes[i]<<(i<end?" ":"");
		else
		{
			int l = 2*C - ((end+1)%2);
			//cout << "l: "<<l << endl;
			for(int i=(end+1-l)/2, j=0; j<l ;j++,i++)
				cout << primes[i]<<(j<l-1?" ":"");
		}
		cout << endl<<endl;
	}
	return 0;
}




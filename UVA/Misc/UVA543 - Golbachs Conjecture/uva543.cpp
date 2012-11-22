#include<iostream>
#include<set>
#include<string>
#include<algorithm>
#include<vector>

using namespace std;

#define all(c) 	(c).begin() , (c).end()


int M;

int main() {
	int n;
	M = 1000000;
	set<int> primes;
	primes.insert(2);
	for (int i = 3; i < M; i++) {
		bool ok = true;
		for (int j = 2; j * j < i + 1; j++) {
			if (!(i % j))
				ok = false;
		}
		if (ok)
			primes.insert(i);
	}

	set<int>::iterator it;
	while (cin >> n && n) {

		for (it = primes.begin(); it != primes.end(); it++) {
			if (primes.count(n - (*it))) {
				cout << n << " = " << *it << " + " << n - (*it) << endl;
				break;
			}

		}
	}

	return 0;
}

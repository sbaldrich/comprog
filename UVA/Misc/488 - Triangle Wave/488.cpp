#include<iostream>

using namespace std;

int main() {

	//freopen("488.in" , "r" , stdin);

	int t, a, f;
	cin >> t;

	while (t--) {
		cin >> a >> f;
		int n;
		for (int i = 0; i < f; i++) {
			n = 1;
			for (int j = 0; j < a && n < a; j++) {
				for (int k = 0; k < n; k++)
					cout << n;
				cout << endl, n++;
			}
			for (int j = n; j > 0; j--) {
				for (int k = 0; k < n; k++)
					cout << n;
				cout << endl,n--;
			}
			if(i < f-1)
				cout << endl;
		}
		if(t>=1)
			cout << endl;
	}
	return 0;
}


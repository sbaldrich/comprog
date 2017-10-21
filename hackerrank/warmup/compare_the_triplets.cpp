#include<iostream>

using namespace std;

int a[6], alice, bob;

int main(){
	for(int i = 0; i < 6; i++) cin >> a[i];
	for(int i = 0; i < 3; i++) alice +=  a[i] > a[i+3], bob += a[i] < a[i+3];
	cout << alice << " " << bob << endl;
	return 0;
}

#include<bits/stdc++.h>

using namespace std;

int main(){
	int n, g;
	cin >> n;
	while(n--){
		cin >> g;
		cout << (g < 38 ? g : g + (g % 5 >= 3 ? 5 - g % 5 : 0)) << endl;
	}
	return 0;
}

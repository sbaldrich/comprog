#include<iostream>

using namespace std;

int main(){
	double k , l, i = 0;
	cin>>k>>l;
	while(l>k) l/=k, i++;
	if(l == k) cout << "YES" << endl << i << endl;
	else cout << "NO" << endl;
	return 0;
}

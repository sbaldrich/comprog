#include<iostream>

using namespace std;

int main(){
	int w;
	cin>>w;
	for(int i=2;i<w;i++)
		if((w-i) % 2 == 0 && i%2 == 0){
			cout << "YES" <<endl;
			return 0;
		}
	cout << "NO" <<  endl;
	return 0;
}

#include<iostream>

using namespace std;

void f(int n){
	if(n < 5)
		cout << "O-|";
	else{ 
		cout << "-O|";
		n -= 5;
	}
	if(n == 0)
		cout << "-OOOO";
	if(n == 1)
		cout << "O-OOO";
	if(n == 2)
		cout << "OO-OO";
	if(n == 3)
		cout << "OOO-O";
	if(n == 4)
		cout << "OOOO-";
}

int main(){
	string n;
	cin >> n;
	for(int i=n.size() - 1; i>=0;i--){
		f(n[i] - '0');
		cout << endl;
	}
	return 0;
		
}

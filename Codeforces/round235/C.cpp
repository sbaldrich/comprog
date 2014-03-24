#include<bits/stdc++.h>

using namespace std;

#define D(x) cout << #x << ": " << x << endl;
int main(){

	int z,o,oo;
	cin >> z >> o;
	oo = o-z;
	oo = ceil(oo/2.0);
	D(oo)
	if( oo > o || oo > z)
		cout << -1;
	else{
		for(int i=0; i<oo; i++, o-=2){
			cout << "11";
			if(z){
				cout << "0";
				z--;
			}
		}
		if( z > o ){
			cout << "0";
			z--;
		}
		for(int i=0; i<z; i++,o--){
			cout << "1";
			if(z){
				cout << "0";
				z--;
			}
		}
		if(o){
			cout << "1";
			o--;
		}
		if(o){
			cout << "1";
			o--;
		}
	}
	cout << endl;
}

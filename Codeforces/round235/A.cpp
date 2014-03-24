#include<bits/stdc++.h>

using namespace std;

int main(){
	
	int n;
	double x,s;
	cin >> n >> x;
	s = 0;
	for(int i=0,y; i<n; i++){
		cin >> y;
		s+=y;
	}
	if( s == 0 )
		cout << 0 << endl;
	else cout << ceil( abs(s) / abs(x)) << endl;
	return 0;
}

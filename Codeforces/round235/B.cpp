#include<bits/stdc++.h>

using namespace std;

int main(){
	
	int x,k;
	cin >> x >> k;
	vector<int> v(x+1,false);
	v[x] = true;
	for(int i,a,b,c; i<k; i++){
		cin >> a >> b;
		if( a == 1 )
			cin >> c;
		v[b] = v[c] = true;
	}
	int l = 0, h = 0;
	for(int i=1; i<=x; i++){
		if(!v[i])
			h++;
	}
	for(int i=1; i<=x; i++){
		if(!v[i]){
			if(!v[i+1])
				i++;
			l++;
		}
	}
	cout << l << " " << h << endl;

}

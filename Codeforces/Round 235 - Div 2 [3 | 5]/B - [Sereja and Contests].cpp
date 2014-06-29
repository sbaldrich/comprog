#include<bits/stdc++.h>

using namespace std;

int main(){
	int x, k;
	cin >> x >> k;
	vector<int> v( x + 1, false);
	v[x] = true;
	for( int i=0, a; i<k; i++ ){
		cin >> a >> b;
		if( a == 1 ){
			cin >> c;
            v[c] = true;
        }
		v[b]  = true;
	}
	int l = 0, h = 0;
	for( int i=1; i<=x; i++ ){
		if( !v[i] )
			h++;
	}
	for( int i=1; i<=x; i++ ){
		if( !v[i] ){
			if( !v[i+1] )
				i++;
			l++;
		}
	}
	cout << l << " " << h << endl;

}

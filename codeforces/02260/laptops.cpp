#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> ii;

int main(){
	int n; cin >> n;
	vector<ii> v;
	for( int i=0, p,q; i <n; i++ ){
		cin >> p >> q;
		v.push_back(ii(p,q));
	}
	sort(v.begin(), v.end() );
	bool ok = false;
	for( int i = 1; i < n; i++ )
		if( v[i].second < v[i-1].second ){
			cout << "Happy Alex" << endl;
			return 0;
		}
	cout << "Poor Alex" << endl;
	return 0;
}

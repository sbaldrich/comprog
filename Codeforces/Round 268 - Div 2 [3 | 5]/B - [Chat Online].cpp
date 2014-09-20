#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> ii;

bool ok( ii p, ii q){
	if( q < p )
		swap( p, q);
	return p.first <= q.first && q.first <= p.second;
}

int main(){
	ios :: sync_with_stdio( 0 );
	cin.tie( 0 );
	vector< ii > v, vv;
	int p,q,l,r; cin >> p >> q >> l >> r;
	for( int i = 0,x,y; i < p; i++ ){
		cin >> x >> y;
		v.push_back( ii(x,y) );
	}
	for( int i = 0, x,y; i <q; i++ ){
		cin >> x >> y;
		vv.push_back( ii(x,y) );
	}
	int ans = 0;
	set<int> ss;
	for( int j = 0; j < vv.size(); j++ ){
		for( int i = l; i <= r; i++ ){
			for( int k = 0; k < v.size(); k++ ){
				if( ok( ii( vv[j].first + i, vv[j].second +i ), v[k] ) ){
					ss.insert( i );
				}
			}
		}	
	}
	cout << ss.size() << endl;
	return 0;
}

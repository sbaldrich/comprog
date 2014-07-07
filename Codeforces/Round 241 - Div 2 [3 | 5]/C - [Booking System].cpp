#include<bits/stdc++.h>

using namespace std;

struct req{
	int p, m, ind;
	req( int ind, int p, int m ) : ind( ind ), p( p ), m( m ) {};
};


bool _cmp( const req &l, const req &r ) {
	return l.m > r.m ? true : l.m == r.m ? l.p < r.p : false; 
}

typedef pair< int, int > ii;
int main(){
	int n, m;
	cin >> n;
	vector< req > requests;
	vector< ii > tables;
	for( int i = 1, c, p; i <= n; i++ ){
		cin >> c >> p;
		requests.push_back( req( i, c, p ) ); 
	} 
	cin >> m;
	for( int i = 1, t; i <= m; i++ ){
		cin >> t;
		tables.push_back( ii( t, i ) );
	}

	sort( requests.begin(), requests.end(), _cmp);
	sort( tables.begin(), tables.end() );

	vector< bool > used( m );
	vector< ii > ans;
	
	int nn = 0, mm = 0;
	for( int i = 0; i < n; i++ ){
		req &ref = requests[i];
		for( int j = 0; j < m; j++ ){
			if( !used[ j ] && ref.p <= tables[j].first ){
				mm += ref.m;
				nn++;
				ans.push_back( ii( ref.ind, tables[j].second ) );
				used[j] = true;
				break;
			}
		}
	}
	cout << nn << " " << mm << endl;
	for( int i = 0 ; i < (int)  ans.size(); i++ )
		cout << ans[i].first << " " << ans[i].second  << endl;
	
	return 0;
}

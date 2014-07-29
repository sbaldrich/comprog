#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> ii;

int main(){
	int k,n; cin >> n >> k;
	vector<int> g[n];
	set<ii> dist;
	for( int i = 0,x; i < n; i++ ){
		cin >> x;
		dist.insert( ii( x, i ) );
	}
	int curdist = 0, curindex=0, ans = 0, root;
	vector<int> curnodes, nextnodes;
	bool possible = true;
	ii top = *dist.begin();
	root = top.second;
	dist.erase( dist.begin() );
	if( top.first || !( dist.begin() -> first ) ){
		cout << "-1" << endl;
		return 0;
	}
	nextnodes.push_back( top.second );
	while( !dist.empty() ){
		ii top = *dist.begin();
		dist.erase( dist.begin() );
		if( top.first > curdist + 1 ){
			possible = false;
			break;
		}
		if( top.first == curdist + 1 ){
			curdist++;
			curnodes = nextnodes;
			nextnodes.clear();
			curindex = 0;
		}
		if( top.first == curdist ){
			while( curindex < curnodes.size() && g[ curnodes[ curindex ] ].size() == k -  ( curnodes[ curindex ] != root ) )
				curindex++;
			if( curindex == curnodes.size() ){
				possible = false;
				break;
			}
			g[ curnodes[ curindex ] ].push_back( top.second );
			++ans;
			nextnodes.push_back( top.second );
		}
	}
	if( possible ){
		cout << ans << endl;
		for( int i = 0; i < n; i++ )
			for( int j = 0; j < (int) g[i].size(); j++ )
				cout << i+1 << " " <<  g[i][j] + 1 << endl;
	}
	else{
		cout << -1 << endl;
	}
	return 0;
}

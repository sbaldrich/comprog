#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

ostream& operator << ( ostream &out, set< ll > s ){
    out << "{";
    for( set< ll >::iterator it = s.begin(); it != s.end(); it ++ )
        out << " " << *it;
    out << " }";
}


int main(){
    int n,k,p; cin >> n >> k >> p;
    vector< ll > even, odd;
    for( int i = 0, x; i < n; i++ ){
        cin >> x;
        if( x & 1LL )
            odd.push_back( x );
        else 
            even.push_back( x ); 
    }
    
	set< ll > seven[ p ] , sodd[ k - p ];
    bool flag = false;
    for( int i = 0, x; i < k - p; i++ ){
        if( odd.empty() ){
            flag = true;
            break;
        }
        sodd[i].insert( odd.back() );
        odd.pop_back();
    }

    if( flag ){
        cout << "NO" << endl;
        return 0;
    }
	for( int i=0; i < p; i++ ){
        if( odd.size() > 1 ){
            seven[i].insert( odd.back() );
            odd.pop_back();
            seven[i].insert( odd.back() );
            odd.pop_back();
        }
        else if( !even.empty() ){
            seven[i].insert( even.back() );
            even.pop_back();
        }
        else{
            flag = true;
            break;
        }
    }
    while( p && odd.size() > 1){
        seven[0].insert( odd.back() );
        odd.pop_back();
        seven[0].insert( odd.back() );
        odd.pop_back();
    }
    
	while( odd.size() > 1){
        sodd[0].insert( odd.back() );
        odd.pop_back();
        sodd[0].insert( odd.back() );
        odd.pop_back();
    }

    if( odd.size() || flag ){
        cout << "NO" << endl;
        return 0;
    }
    while( p && !even.empty() ){
        seven[0].insert( even.back() );
        even.pop_back();
    }

	while( ( k - p ) && !even.empty() ){
		sodd[0].insert( even.back() );
		even.pop_back();
	}
    cout << "YES" << endl;
    for( int i = 0; i < p; i++ ){
        cout << seven[i].size();
        for( typeof( seven[i].begin() ) it = seven[i].begin(); it!= seven[i].end(); it++ )
            cout<< " " << *it;
        cout << endl;
    }
    for( int i = 0; i < k-p; i++ ){
        cout << sodd[i].size();
        for( typeof( sodd[i].begin() ) it = sodd[i].begin(); it!= sodd[i].end(); it++ )
            cout<< " " << *it;
        cout << endl;
    }

    return 0;
}

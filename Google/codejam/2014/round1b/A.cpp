#include<bits/stdc++.h>

using namespace std;

string unq( const string &s ){
	string ret = "";
	for( int i=0; i < (int)s.size(); i++ )
		if( i == 0 || s[i] != s[i-1])
			ret += s[i];
	return ret;
}

int f( const int &p, vector<string> &v, const string &t){
	//cout << "f( " << p << ", " << t << ")" << endl;
	vector<int> quant( (int)v.size() );
	for( int i=0,c,d, pos; i < (int)v.size(); i++ ){
		string &word = v[i];
		c = 0;
		d = 0;
		//cout << "looking for " << t[p] << " in " << word << endl; 	
		int n = word.size();
		for( int j=0; d < p && j < n - 1; j++ ){
			if( word[j] != word[j+1] )
				d++;
			if( d == p )
				pos = j+1;
		}
		//cout << "char " << t[p] << " is at " << pos << " in " << word << endl;
		for( int k = pos; k < n && word[k] == word[pos]; k++ ){
			c++;
			quant[i] = c;
		}
	}
	
	/*cout << "quant for character " << t[p] << ": ";
	for( int i=0; i< (int) v.size(); i++ )
		cout << quant[i] << " ";
	cout << endl;
	*/
	sort( quant.begin(), quant.end() );
	int m = v.size() / 2;
	int ret = 0;
	for( int i=0; i<quant.size(); i++ )
		ret += abs( quant[i] - quant[m] );
	if( m & 1 ){
		m++;
		int xx = 0;
		for( int i=0; i<quant.size(); i++ )
			xx += abs( quant[i] - quant[m] );
		ret = min( ret, xx );
	}
	//cout << "For char " << t[p] << " " << ret << " changes are necessary" << endl;
	return ret;
}

int main(){
	int T, N;
	cin >> T;
	string t="";
	for( int caze = 1 ; caze <= T; caze++ ){
		cin >> N;
		vector<string> v(N);
		bool ok = true;
		for( int i=0; i<N; i++ ){
			cin >> v[i];
			if( i == 0 )
				t = unq(v[i]);
			else
				ok &= ( t == unq(v[i]) );
		}

		cout << "Case #" << caze<< ": ";
		if( !ok )
			cout << "Fegla Won" << endl;
		else{
			long long ans = 0LL;
			for( int i=0; i < (int)t.size(); i++ )
				ans += f(i, v, t);
			cout << ans << endl;
		}

	}
	return 0;
}

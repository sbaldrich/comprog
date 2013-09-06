#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool _cmp(const string &s, const string &t){
	return s.size() < t.size();
}

int main(){
	freopen("B.in" , "r" , stdin);
	int n,q;
	cin>>n>>q;
	vector<string> v(n);
	for(int i=0;i<n;i++)
		cin>>v[i];
	//sort(v.begin(),v.end(),_cmp);
	string s;
	while(q--){	
		cin>>s;
		//cout << "read " << s << endl;
		int best = -1, match = 0, m, l = s.size();
		for(int i=0;i<n;i++){
			//cout << "Chose " << v[i] << endl;
			//cout << "s -> " << s << endl;
			//cout << "l -> " << l << endl;
			if( l > v[i].size())
				continue;
			for(int j=0;j <= (v[i].size() - l); j++){
				//cout << "v[" <<  i << "] -> " << v[i].size() << endl;
				//cout << "lim " << (v[i].size() - l) << endl;
				m = 0;
				for(int k=0;k<l;k++){
					if(s[k] == v[i][j+k])
						m++;
				}
				//cout << m << " matches " << endl;
				if(m > match){
					match = m;
					best = i;
				}
			}
		}
		cout << best + 1 << endl;
	}
	return 0;
}

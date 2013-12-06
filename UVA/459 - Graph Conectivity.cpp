#include<iostream>
#include<set>

using namespace std;

#define TRACE(x) cout << "[ " << #x << " => " << x << " ]" << endl;

const int NN = 30;

int p[NN];

int root(int x){ return p[x] == x? x : p[x] = root(p[x]);}
bool union_find(int a, int b){
	p[root(a)] = b = root(b);
		return a != b;
}

int main(){
	freopen("aa.in", "r" , stdin);
	int n;
	cin >> n;
	string line;
	cin >> line;
	for(int tc = 0, m; tc < n; tc++){	
		if(tc)
			cout << endl;
		m = line[0] - 'A' + 1;
		for(int i=0; i<m; i++)
			p[i] = i;
		while( cin >> line && line.size() == 2 ){
			union_find(line[0] - 'A', line[1] - 'A');
		}
		for(int i=0; i<m; i++)
			root(i);
	
		set<int> s(p,p+m);
		cout << s.size() << endl;

	}
	return 0;
}

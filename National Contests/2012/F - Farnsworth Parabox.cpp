#include<iostream>
#include<iomanip>
#include<cstring>
#include<utility>
#include<queue>
#include<vector>
#include<set>

using namespace std;

typedef pair<int,int> state;

#define fs first
#define sc second 
#define mp make_pair
template<class S, class T>
ostream& operator<<(ostream &o, const pair<S,T> &p){
	return o << "< " << p.fs << ", " << p.sc << ">";
}

vector< vector< state > > g;
set<state> visit;
bool bfs(int su = 0, int t = 0){
	queue<state> q;
	q.push(mp(su,t));	
	while(!q.empty()){
		state x,y;
		x = q.front();q.pop();
		//cout << "front " << x << endl;
		visit.insert(x);
		if(x.fs == su && x.sc < 0)
			return true;
		for(int i=0;i<g[x.fs].size();i++){
			y = g[x.fs][i];
			//cout << "analyzing " << y << endl;
			if(visit.find(y = state(y.fs, x.sc + y.sc)) == visit.end()  )
				q.push(y);
			//else cout << "nope" << endl;
		}
	}
	return false;
}


int main(){
	freopen("F.in" , "r", stdin);
	for(int m,n;cin>>m>>n && m && n;){
		g = vector< vector< state > >(m, vector< state > ());
		visit.clear();
		int c,a,b;
		for(int i=0;i<n;i++){
			cin >> a >> b >>c;	
			--a,--b;
			g[a].push_back(state(b, c));
			g[b].push_back(state(a, -c));
		}
		cout << (bfs()?"Y":"N") << endl;
	}
	return 0;
}

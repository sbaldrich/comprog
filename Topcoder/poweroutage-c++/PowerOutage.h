#include <algorithm>
#include <iostream>
#include <map>
#include <numeric>
#include <set>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

#define FOR(i,s,e) for (int i = int(s); i != int(e); i++)
#define FORIT(i,c) for (typeof((c).begin()) i = (c).begin(); i != (c).end(); i++)
#define ISEQ(c) (c).begin(), (c).end()
#define fi(n,i) FOR(i,0,n)
#define max(a,b) a>b?a:b
typedef vector<int> vi;



class PowerOutage {


	vector<vi> graph, cost;

	int lp(int node)
	{
		int ret = 0;
		fi(graph[node].size(),i)
			ret = max(ret , lp(graph[node][i]) + cost[node][i]);
		return ret;
	}

	public:

	int estimateTimeOut(vector<int> from, vector<int> to, vector<int> len) {
		graph.clear();
		cost.clear();
		graph.resize(100);
		cost.resize(100);
		int ans = 0;
		fi(from.size(), i)
		{
			graph[from[i]].push_back(to[i]);
			cost[from[i]].push_back(len[i]);
			ans+=len[i];
		}
		return (ans << 1) - lp(0);
	}

};

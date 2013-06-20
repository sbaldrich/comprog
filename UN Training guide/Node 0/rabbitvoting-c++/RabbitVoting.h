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
#define max(a,b) (a)>(b)?(a):(b)
class RabbitVoting {

	public: string getWinner(vector<string> names, vector<string> votes) {
		int m = -1;
		map<string,int> v;
		v.clear();
		for(int i=0;i<(int)names.size();i++)
			if(names[i].compare(votes[i]) == 0)
				continue;
			else
				v[votes[i]]++,m = max(m , v[votes[i]]);
		if(m<0)
			return "";
		string winner = "";

		for(map<string,int> :: iterator it = v.begin(); it!=v.end();it++)
		{
			if(it->second == m)
				if(!winner.empty())
					return "";
				else winner = it->first;

		}

		return winner;


	}

};

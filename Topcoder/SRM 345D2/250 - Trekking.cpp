#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

class Trekking {
public:
	int findCamps(string, vector <string>);
};

int Trekking::findCamps(string trail, vector <string> plans) {
	int m = plans.size() , n = trail.size(), ans = -1, act = 0;
	for(int i=0;i<m;i++)
	{
		act = 0;
		bool valid = true;
		for(int j=0;j<n;j++)
		{
			if(plans[i][j] == 'C')
				if(trail[j] == '.')
					act++;
				else
				{
					valid = false;
					break;
				}	
		}
		if(valid)
			ans = ans == -1? act : min(ans,act);
	}	
	return ans;
}



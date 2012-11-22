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

class RollingDiceDivTwo {

	public: int minimumFaces(vector<string> rolls) {
		for(int i=0;i<rolls.size();i++)
			sort(ISEQ(rolls[i]));
		vector<int> faces(rolls[0].size(), 0);
		for(int i=0;i<rolls.size();i++)
		{
			for(int j=0;j<rolls[0].size();j++)
			{
				faces[j] = faces[j]>rolls[i][j]-'0'?faces[j]:rolls[i][j]-'0';
			}
		}

		return accumulate(ISEQ(faces), 0);
	}

};

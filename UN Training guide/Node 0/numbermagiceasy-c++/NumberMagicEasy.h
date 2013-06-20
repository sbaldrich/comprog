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
#define all(c) (c).begin(), (c).end()

class NumberMagicEasy {

public:
	int theNumber(string answer) {
		int cards[][8] = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 9, 10, 11,
				12 }, { 1, 2, 5, 6, 9, 10, 13, 14 }, { 1, 3, 5, 7, 9, 11, 13, 15 } };
		vector<int> c[4], add, sub, x;
		vector<int>::iterator it;
		for (int i = 0; i < 4; i++) {
			c[i] = vector<int>(cards[i], cards[i] + 8);
			if (answer[i] == 'Y') {
				if (add.empty())
					add = c[i];
				else {
					x.resize(add.size() + c[i].size());
					it = set_intersection(all(c[i]), all(add) , x.begin());
					x.resize(it - x.begin());
					add = x;
				}
			} else {
				if (sub.empty())
					sub = c[i];
				else {
					x.resize(sub.size() + c[i].size());
					it = set_union(all(c[i]), all(sub) , x.begin());
					x.resize(it - x.begin());
					sub = x;
				}
			}
		}
		x.resize(10);
		it = set_difference(all(add), all(sub) , x.begin());
		x.resize(it - x.begin());
		if (x.empty())
			return 16;
		else
			return x[0];

	}

};

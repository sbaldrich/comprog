#include <bits/stdc++.h>

using namespace std;

class CombiningSlimes {
public:
	int maxMascots(vector <int> a) {
		int ans = 0;
		while(a.size() > 1){
			int x = a.back(); a.pop_back();
			int y = a.back(); a.pop_back();
			a.push_back(x + y);
			ans += x*y;
		}
		return ans;
	}
};

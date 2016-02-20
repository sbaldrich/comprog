/*
 * Created on: Jan 18, 2012
 * Author: sbaldrich
 * Problem: C - Mahershalalhashbaz, Nebuchadnezzar, and Billy Bob Benjamin Go to the Regionals
 *
 * Greedy.Sort the names by length, find the average on each group of k people. Compare each member and break
 * if you can't form the group properly.
 * O(n)
 */

#include<algorithm>
#include<string>
#include<vector>
#include<cstdio>
#include<iostream>

using namespace std;

#define abs(x) (x)<0?-(x):(x)

bool cmp(string a, string b) {
	if (a.size() < b.size())
		return true;
	else
		return false;
}

int main() {
	//freopen("C.in", "r", stdin);
	int n, k, z = 1;
	vector<string> names;
	bool flag = false;
	while (cin >> n >> k && n && k) {
		if (flag)
			cout << endl;
		names = vector<string>(n);
		for (int i = 0; i < n; i++)
			cin >> names[i];
		sort(names.begin(), names.end(), cmp);
		bool ok = true;
		for (int i = 0, t=0; t < n / k; i+=k, t++) {
			if (!ok)
				break;
			double avg = 0.0;
			for (int j = i, q = 0; q < k; j++, q++)
				avg += names[j].size();
			avg /= (double) k;
			for (int j = i, q = 0; q < k; j++, q++) {
				double dist = abs(names[j].size() - avg);
				if ( dist > 2.0) {
					ok = false;
					break;
				}
			}

		}
		flag = true;
		cout << "Case " << z++ << ": " << (ok ? "yes" : "no") << endl;
	}
	return 0;
}


/*
 * Created on: Jan 19, 2012
 * Author: sbaldrich
 * Problem E - Plaque Pack
 *
 * Keep record of the highest place occupied on the container. ( top in the following code ) For each column
 * check what the highest and lowest place is. Add to this the difference to the top plus one and voil‡.
 * (Yeah, I know the description isn't quite perfect, but the code can speak for itself)
 */
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<cstdio>

using namespace std;

#define max(a,b) (a)>(b)?(a):(b)
#define min(a,b) (a)<(b)?(a):(b)

ostream& operator<<(ostream& o, vector<int>&v) {
	o << "{ ";
	for (int i = 0; i < (int) v.size(); i++)
		o << v[i] << " ";
	o << " }";
	return o;
}

int main() {
	//freopen("E.in", "r", stdin);
	int n, w, b, h;
	string x;
	vector<int> top, hi, lo;
	while (cin >> n >> w >> b && n) {
		top = vector<int>(w, 0);
		bool flag = false;
		for (int i = 0; i < n; i++) {
			cin >> h;
			hi = vector<int>(w, 0);
			lo = vector<int>(w, 0);
			for (int j = 0; j < h; j++) {
				cin >> x;
				for (int k = 0; k < w; k++) {
					if (x[k] == 'X') {
						hi[k] = max(hi[k] , h-j);
						lo[k] = lo[k] == 0 ? hi[k] : min(lo[k] , h-j);
					}
				}
			}
			//cout << "top:     "<<top << endl;
			//cout << "start hi " << hi << endl << "start lo " << lo << endl;
			int offset = 0;
			for (int k = 0; k < w; k++) {
				if ((lo[k] + offset) <= top[k])
					offset += (top[k] - lo[k] - offset) + 1;
				if ((hi[k] + offset) <= top[k])
					offset += (top[k] - hi[k] - offset) + 1;
				//cout << "on "<<k<<" offset is "<<offset << endl;
			}
			//cout << "final offset is " << offset << endl;
			lo = hi;
			for (int k = 0; k < w; k++)
				hi[k] += offset;

			//cout << "hi: " << hi << endl << "lo: " << lo << endl;
			int m = *max_element(hi.begin(),hi.end());
			if(m>b)
			{
				cout << (flag?" ":"")<<*max_element(top.begin(),top.end());
				top = lo;
				flag = true;
			}
			else top = hi;
		}
		cout <<(flag?" ":"")<<*max_element(top.begin(),top.end()) << endl;

	}
	return 0;
}


/*
 * Created on: Nov 2, 2011
 * Author: sbaldrich
 *
 */

#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

#define min(a,b) (a)<(b)?(a):(b)
struct point{
	int x,y;
	point(int x,int y):x(x),y(y){}
};

int main() {
	freopen("cake.in", "r", stdin);
	int N, x, y, l, r;
	vector<point> V;
	while (cin >> N && N) {
		int minx=0 , miny=0;
		V.clear();
		for (int i = 0; i < 2*N; i++) {
			cin >> x >> y;
			V.push_back(point(x, y));
			minx=min(minx,x),miny=min(miny,y);
		}
		int A, B;
		bool done = false;
		minx = abs(minx) , miny=abs(miny);
		for (A = -500; A <= 500 && !done; A++) {
			bool ok = true;
			for (B = -500; B <= 500 && ok; B++) {
				l = r = 0;
				for (int i = 0; ok && i < (int) V.size(); i++) {
					int m = A*(V[i].x+minx) + B*(V[i].y+miny);
					if (m-minx-miny < 0)
						l++;
					else if (m-minx-miny > 0)
						r++;
					else
					{
						ok = false;
						break;
					}
				}
				if (ok && l == r) {
					cout << A <<" "<< B << endl;
					done = true;
					break;
				}
			}
		}

	}
	return 0;

}


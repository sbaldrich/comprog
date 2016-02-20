/*
 * Created on: 07/11/2011
 * Author: sbaldrich
 * Problem: G - Convex Hull of Lattice Points
 * Source: Greater New York 2009
 */

#include <algorithm>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

typedef long long CoordType;


struct Point {
	CoordType x, y;
	Point(){}
	Point(CoordType x, CoordType y):x(x),y(y){}
	bool operator <(const Point &p) const {
		return x < p.x || (x == p.x && y < p.y);
	}
};

CoordType cross(const Point &O, const Point &A, const Point &B) {
	return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
}

vector<Point> convexHull(vector<Point> P) {
	int n = P.size(), k = 0;
	vector<Point> H(2 * n);

	sort(P.begin(), P.end());

	for (int i = 0; i < n; i++) {
		while (k >= 2 && cross(H[k - 2], H[k - 1], P[i]) <= 0)
			k--;
		H[k++] = P[i];
	}

	for (int i = n - 2, t = k + 1; i >= 0; i--) {
		while (k >= t && cross(H[k - 2], H[k - 1], P[i]) <= 0)
			k--;
		H[k++] = P[i];
	}
	H.resize(k);
	return H;
}
double cx,cy;

const double EPS = 1e10;
inline int cmp(double x , double y=0.0,double tol = EPS)
{
	return (x<=y+tol) ? (x+tol<y)?-1:0:1;
}

bool std_cmp(Point p , Point q)
{
	if(cmp(atan2(p.y-cx,p.x-cx), atan2(q.y-cy ,q.x-cx)) == 1)
		return true;
	return false;
}

int find_first(vector<Point> &v)
{
	int best = 0;
	for(int i=1;i<(int)v.size();i++)
	{
		if(v[best].y < v[i].y)
			best = i;
		else if(v[best].y == v[i].y && v[best].x > v[i].x)
			best =i;
	}
	return best;
}


int main() {

	//freopen("G.in", "r", stdin);

	int P, c, N, x, y;
	cin >> P;
	vector<Point> points, hull;
	for (int z = 0; z < P; z++) {
		points.clear();
		cin >> c >> N;
		for (int i = 0; i < N; i++) {
			cin >> x >> y;
			points.push_back(Point(x, y));
		}
		hull = convexHull(points);
		hull.erase(hull.begin() + hull.size());
		cout << c << " " << hull.size() << endl;

		cx=0.0 , cy=0.0;
		for(int i=0;i<(int)hull.size();i++)
		{
			cx+=hull[i].x;
			cy+=hull[i].y;
		}
		cx /= hull.size();
		cy /= hull.size();

		sort(hull.begin(),hull.end(),std_cmp);
		reverse(hull.begin(),hull.end());
		for (int i = find_first(hull) , q=0; q<(int)hull.size(); q++,i=(i+1)%hull.size())
			cout << hull[i].x << " " << hull[i].y << endl;

	}
	return 0;
}

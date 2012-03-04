/*
 * Created on: 08/11/2011
 * Author: sbaldrich
 * Problem: H - Interior Points of Lattice Polygons
 * Source: Greater New York 2009
 *
 */

#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>
#include <map>
#include <utility>

using namespace std;

#define mp make_pair
#define min(a,b) (a)<(b)?(a):(b)
#define max(a,b) (a)>(b)?(a):(b)

const double EPS = 1e-10;
const int oo = 0x3FFFFFFF;

inline int cmp(double x, double y = 0, double tol = EPS) {
	return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}

int mod(int a, int b)
{
	 int r = a%b;
	 return r<0 ? r+b : r;
}

class Point {
public:
	Point(double x_ = 0.0, double y_ = 0.0) :
			x(x_), y(y_) {
	}

	Point operator +(const Point &o) const {
		return Point(x + o.x, y + o.y);
	}
	Point operator -(const Point &o) const {
		return Point(x - o.x, y - o.y);
	}
	Point operator *(const double &m) const {
		return Point(m * x, m * y);
	}
	Point operator /(const double &m) const {
		return Point(x / m, y / m);
	}
	// Dot Product
	double operator *(const Point &o) const {
		return x * o.x + y * o.y;
	}
	// Cross Product
	double operator ^(const Point &o) const {
		return x * o.y - y * o.x;
	}

	int cmp(Point o) const {
		if (int t = ::cmp(x, o.x))
			return t;
		return ::cmp(y, o.y);
	}
	bool operator ==(const Point &o) const {
		return cmp(o) == 0;
	}
	bool operator !=(const Point &o) const {
		return cmp(o) != 0;
	}
	bool operator <(const Point &o) const {
		return cmp(o) < 0;
	}

	double Distance(const Point &o) const {
		double d1 = x - o.x, d2 = y - o.y;
		return sqrt(d1 * d1 + d2 * d2);
	}

	double Distance(const Point &p1, const Point &p2,
			const bool &isSegment) const {
		double dist = ((p2 - p1) ^ (*this - p1)) / p2.Distance(p1);
		if (isSegment) {
			double dot1 = (*this - p2) * (p2 - p1);
			if (::cmp(dot1) > 0)
				return sqrt((p2 - *this) * (p2 - *this));
			double dot2 = (*this - p1) * (p1 - p2);
			if (::cmp(dot2) > 0)
				return sqrt((p1 - *this) * (p1 - *this));
		}
		return abs(dist);
	}

	friend ostream& operator <<(ostream &o, Point p) {
		return o << "(" << p.x << ", " << p.y << ")";
	}

	double x, y;
	static Point pivot;
};

Point Point::pivot(0, 0);

inline int turn(const Point &p, const Point &q, const Point &r) {
	return ::cmp((p - r) ^ (q - r));
}

bool lower_cmp(Point &p , Point &q)
{
	if(p.y < q.y)
		return true;
	if(p.y == q.y)
		return p.x < q.x;
	return false;
}

int slope(Point &p , Point &q)
{
	if(q.x == p.x)
		 return oo;
	if(q.y == p.y)
		return 0;
	double s = (q.y - p.y)/(q.x -  p.x);
	return cmp(s);
}

typedef vector<Point> Polygon;
int main() {
	//freopen("H.in", "r", stdin);
	int P, c, N, x, y; //As problem statement
	cin >> P;
	Polygon poly;
	vector< pair<int, Point > >ans;
	for (int z = 0; z < P; z++) {
		poly.clear();
		ans.clear();
		cin >> c >> N;
		for (int i = 0; i < N; i++) {

			cin >> x >> y;
			poly.push_back(Point(x, y));

		}
		int start = min_element(poly.begin(),poly.end(),lower_cmp) -poly.begin(),
				n = poly.size();
		int end = max_element(poly.begin(),poly.end(),lower_cmp) - poly.begin();

		Point A,B,C,D,X,Y;

		A = C = poly[start];
		B = poly[mod(start+1,n)]; D = poly[mod(start-1,n)];

		int left = start+1,right=start-1 ;
		for(int y = A.y + 1;y<poly[end].y;y++)
		{



			if(slope(A,B) == 0)
				A = B,B=poly[mod(++left,n)];
			if(slope(C,D) == 0)
				C = D,D=poly[mod(--right,n)];

			X.x = max(A.x,B.x);
				X.y = Y.y = y;

			if(slope(A,B)==oo)
				X.x++;

			while(turn(C,D,X) <= 0)
				X.x--;
			while(turn(A,B,X) == -turn(C,D,X))
				X.x--;
			X.x++;

			Y.x = X.x;
			while(turn(A,B,Y) == -turn(C,D,Y))
				Y.x++;
			Y.x--;
			if(y == B.y)
				A = B,B=poly[mod(++left,n)];
			if(y == D.y)
				C = D,D=poly[mod(--right,n)];
			if(turn(A,B,X) == -turn(C,D,X) && X.x <= Y.x)
				if(turn(A,B,Y) == -turn(C,D,Y) && Y.x >= X.x)
				     ans.push_back(mp(y,Point(X.x,Y.x)));

		}
		reverse(ans.begin(),ans.end());
		cout << c << " " << ans.size()<<endl;
		for(int i=0;i<ans.size();i++)
			cout << ans[i].first <<" " <<ans[i].second.x << " " << ans[i].second.y << endl;
	}
	return 0;
}



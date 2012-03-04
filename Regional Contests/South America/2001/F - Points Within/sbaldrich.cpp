/*
 * Created on: 15/11/2011
 * Author: sbaldrich
 * F - Points Within
 * South America Regional Contest 2001
 */

#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

const double EPS = 1e-10;

inline int cmp(double x, double y = 0, double tol = EPS) {
  return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}

class Point {
 public:
  Point(double x_ = 0.0, double y_ = 0.0) : x(x_), y(y_) {}

  Point operator +(const Point &o) const { return Point(x + o.x, y + o.y); }
  Point operator -(const Point &o) const { return Point(x - o.x, y - o.y); }
  Point operator *(const double &m) const { return Point(m * x, m * y); }
  Point operator /(const double &m) const { return Point(x / m, y / m); }

  double operator *(const Point &o) const { return x * o.x + y * o.y; }

  double operator ^(const Point &o) const { return x * o.y - y * o.x; }

  int cmp(Point o) const {
    if (int t = ::cmp(x, o.x)) return t;
    return ::cmp(y, o.y);
  }
  bool operator ==(const Point &o) const { return cmp(o) == 0; }
  bool operator !=(const Point &o) const { return cmp(o) != 0; }
  bool operator < (const Point &o) const { return cmp(o) < 0; }


  double Distance(const Point &o) const {
    double d1 = x - o.x, d2 = y - o.y;
    return sqrt(d1 * d1 + d2 * d2);
  }

  double Distance(const Point &p1, const Point &p2,
 const bool &isSegment) const {
    double dist = ((p2 - p1) ^ (*this - p1)) / p2.Distance(p1);
    if (isSegment) {
      double dot1 = (*this - p2) * (p2 - p1);
      if (::cmp(dot1) > 0) return sqrt((p2 - *this) * (p2 - *this));
      double dot2 = (*this - p1) * (p1 - p2);
      if (::cmp(dot2) > 0) return sqrt((p1 - *this) * (p1 - *this));
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

inline double angle(const Point &p, const Point &q, const Point &r) {
  Point u = p - r, v = q - r;
  return atan2(u ^ v, u * v);
}


inline int turn(const Point &p, const Point &q, const Point &r) {
  return ::cmp((p - r) ^ (q - r));
}


inline bool between(const Point &p, const Point &q, const Point &r) {
  return turn(p, r, q) == 0 && ::cmp((p - r) * (q - r)) <= 0;
}

int InPolygon(const Point &p, const vector<Point> &T) {
  double a = 0; int N = T.size();
  for (int i = 0; i < N; ++i) {
    if (between(T[i], T[(i + 1) % N], p)) return -1;
    a += angle(T[i], T[(i + 1) % N], p);
  }
  return ::cmp(a) != 0;
}

bool RadialComp(const Point &p, const Point &q) {
  Point P = p - Point::pivot, Q = q - Point::pivot;
  double R = P ^ Q;
  if (::cmp(R)) return R > 0;
  return ::cmp(P * P, Q * Q) < 0;
}


typedef vector<Point> polygon;

int main()
{
	//freopen("F.in", "r", stdin);
	int x, y,N,M,test=1;
	polygon poly;
	Point p;
	bool line = false;
	while(cin>>N && N)
	{
		if(line)
			cout << endl;
		poly.clear();
		cin>>M;
		for(int i=0;i<N;i++)
		{
			cin>>x>>y;
			poly.push_back(Point(x,y));
		}
		cout << "Problem "<<test++<<":"<<endl;
		for(int i=0;i<M;i++)
		{
			cin>>x>>y;
			p = Point(x,y);
			cout << (InPolygon(p,poly)!=0?"Within":"Outside")<<endl;
		}
		line = true;
	}
	return 0;
}





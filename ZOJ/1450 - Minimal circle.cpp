#include<algorithm>
#include<vector>
#include<cmath>
#include<iostream>
#include<sstream>
#include<string>
#include<iomanip>
#include<utility>
#include<cstdio>

using namespace std;

#define dump(x) if(debug)cerr << #x << " -> " << x

const bool debug = true;
const double EPS = 1e-10;
const int oo = 0x3F3F3F;
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
  // Dot Product
  double operator *(const Point &o) const { return x * o.x + y * o.y; }
  // Cross Product
  double operator ^(const Point &o) const { return x * o.y - y * o.x; }

  int cmp(Point o) const {
    if (int t = ::cmp(x, o.x)) return t;
    return ::cmp(y, o.y);
  }
  bool operator ==(const Point &o) const { return cmp(o) == 0; }
  bool operator !=(const Point &o) const { return cmp(o) != 0; }
  bool operator < (const Point &o) const { return cmp(o) < 0; }

  friend ostream& operator <<(ostream &o, Point p) {
    return o << "(" << p.x << ", " << p.y << ")";
  }

  double x, y;
  static Point pivot;
};

Point Point::pivot(0, 0);

typedef pair<Point, double> circle;

double abs(Point p) {return hypot(p.x, p.y);}

Point circumcenter(Point p, Point q, Point r){
	Point a = p-r, b = q-r, c = Point(a * (p + r) /2, b * (q+r) /2);
	return Point(c ^ Point(a.y, b.y), Point(a.x, b.x) ^ c ) / (a ^ b);
}

bool in_circle(circle C, Point p){
	return cmp(abs(p - C.first), C.second) <= 0;
}

circle spanning_circle(vector<Point> &T){
	int n = T.size();
	random_shuffle(T.begin(),T.end());
	circle C(Point(), -oo);
	for(int i=0;i<n;i++) if(!in_circle(C,T[i])){
		C = circle(T[i],0);
		for(int j=0; j<i; j++) if (!in_circle(C, T[j])){
			C = circle((T[i] + T[j] ) / 2, abs(T[i] - T[j]) / 2);
			for(int k=0; k<j; k++) if(!in_circle(C,T[k])){
				Point o = circumcenter(T[i], T[j], T[k]);
				C = circle(o, abs(o - T[k]));
			}
		}
	}
	return C;
}


int main(){
//	freopen("circle.in" , "r", stdin);
	for(int n; cin>>n && n;){
		double x,y;
		vector<Point> p(n);
		for(int i=0;i<n;i++){
			cin>>x>>y;
			p[i] = Point(x,y);
		}
		circle c = spanning_circle(p);
		printf("%.2f %.2f %.2f\n" , c.first.x, c.first.y, c.second);
	}	
	return 0;
}

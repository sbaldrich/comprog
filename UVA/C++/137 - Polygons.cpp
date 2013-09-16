#include<cmath>
#include<vector>
#include<iostream>
#include<iomanip>
#include<algorithm>
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

  //Not necessary for minimal Point declaration so they're declared as prototypes.
  //Just to know they're there :3
  double distance(const Point &o) const;
  double distance(const Point &p1, const Point &p2, const bool &isSegment) const;

  friend ostream& operator <<(ostream &o, Point p) {
    return o << "(" << p.x << ", " << p.y << ")";
  }

  double x, y;
  static Point pivot;
};

Point Point::pivot(0, 0);

double abs(Point p) {return hypot(p.x, p.y);}
double arg(Point p) {return atan2(p.y, p.x);}


//Determine whether the segments p--q and r--s have points in common
bool seg_intersect(Point p, Point q, Point r, Point s){
	Point A = q - p, B = s - r, C = r - p, D = s - q;
	int a = cmp(A ^ C) + 2 * cmp(A ^ D);
	int b = cmp(B ^ C) + 2 * cmp(B ^ D);
	if( a == 3 || a == -3 || b == 3 || b == -3) return false;
	if( a || b || p == r || p == s || q == r || q == s) return true;
	int t = (p < r) + (p < s) + (q < r) + (q < s);
	return t != 0 && t != 4;
} 

inline double angle(const Point &p, const Point &q, const Point &r) {
  Point u = p - q, v = r - q;
  return atan2(u ^ v, u * v);
}

inline int turn(const Point &p, const Point &q, const Point &r) {
  return ::cmp((p - r) ^ (q - r));
}

inline bool between(const Point &p, const Point &q, const Point &r) {
  return turn(p, r, q) == 0 && ::cmp((p - r) * (q - r)) <= 0;
}

Point intersection(const Point &p, const Point &q, const Point &r,
		   const Point &s) {
  Point a = q - p, b = s - r, c = Point(p ^ q, r ^ s);
  return Point(Point(a.x, b.x) ^ c, Point(a.y, b.y) ^ c) / (a ^ b);
}

bool radial_comp(const Point &p, const Point &q) {
  Point P = p - Point::pivot, Q = q - Point::pivot;
  double R = P ^ Q;
  if (::cmp(R)) return R > 0;
  return ::cmp(P * P, Q * Q) < 0;
}

typedef vector<Point> polygon;

/*Remember that THE FUCKING POLYGON SHOULD BE ORDERED CLOCKWISE
 OR COUNTER-CLOCKWISE FOR THIS ALGORITHM TO WORK.
*/
int in_polygon(const Point &p, const vector<Point> &T) {
  double a = 0; int N = T.size();
  for (int i = 0; i < N; ++i) {
    if (between(T[i], T[(i + 1) % N], p)) return -1;
    a += angle(T[i], T[(i + 1) % N], p);
  }
  return ::cmp(a) != 0;
}


/*Is the polygon sorted clockwise or counter-clockwise? 
  if not, I'll find you. I swear, I'll find you and fucking kill you.
*/

double area(const vector<Point> &T) {
  double area = 0.0;
  for(int i = 1; i + 1 < T.size(); i++){
    area += (T[i] - T[0]) ^ (T[i + 1] - T[0]);
  }
  return abs(area / 2.0);
}

polygon poly_intersect(polygon &P, polygon &Q){
	int m = Q.size(), n = P.size();
	int a = 0, b = 0, aa = 0, ba = 0, inflag = 0;
	polygon R;
	while( (aa < n || ba < m) && aa < 2*n && ba < 2*m){
		Point p1 = P[a], p2 = P[(a+1) % n], q1 = Q[b], q2 = Q[(b+1) % m];
		Point A = p2 - p1, B = q2 - q1;
		int cross = cmp(A ^ B), ha = turn(p2, q2, p1), hb = turn(q2, p2, q1);
		if(cross == 0 && turn(p1, q1, p2) == 0 && cmp(A * B) < 0){
			if(between(p1, q1, p2)) R.push_back(q1);
			if(between(p1, q2, p2)) R.push_back(q2);
			if(between(q1, p1, q2)) R.push_back(p1);
			if(between(q1, p2, q2)) R.push_back(p2);
			if(R.size() < 2) return polygon();
			inflag = 1; break;
		}else if(cross != 0 && seg_intersect(p1, p2, q1, q2)) {
			if(inflag == 0) aa = ba = 0;
			R.push_back(intersection(p1, p2, q1, q2));
			inflag = (hb > 0) ? 1 : -1;
		}
		if(cross == 0 && hb < 0 && ha < 0) return R;
		bool t = cross == 0 && hb == 0 && ha == 0;
		if(t ? (inflag == 1) : (cross >= 0) ? (ha <= 0) : (hb > 0)){
			if(inflag == -1) R.push_back(q2);
			ba++; b++; b %= m;
		}else{
			if(inflag == 1) R.push_back(p2);
			aa++; a++; a %= n;
		}
	}

	if(inflag == 0){
		if (in_polygon(P[0], Q)) return P;
		if (in_polygon(Q[0], P)) return Q;
	}
	R.erase(unique(R.begin(), R.end()), R.end());
	if(R.size() > 1 && R.front() == R.back()) R.pop_back();
	return R;
}

template<class t>
ostream& operator<<(ostream &o, const vector<t> &v){
	for(int i=0;i<v.size();i++)
		o << v[i] << " ";
	return o;
}

int main(){
	freopen("137.in" , "r", stdin);
	polygon p,q,r;
	for(int n,m,x,y; cin>>n && n;){
		p = polygon(n);
		for(int i=0;i<n;i++){
			cin>>x>>y;
			p[i] = Point(x,y);
		}
		cin>>m;
		q = polygon(m);
		for(int i=0;i<m;i++){
			cin>>x>>y;
			q[i] = Point(x,y);
		}
		
		Point :: pivot = *min_element(p.begin(), p.end());
		sort(p.begin(),p.end(), radial_comp);
		Point :: pivot = *min_element(q.begin(), q.end());
		sort(q.begin(),q.end(), radial_comp);

		r = poly_intersect(q,p);

		Point :: pivot = *min_element(r.begin(),r.end());
		sort(r.begin(),r.end(), radial_comp);
		double ans = area(p) + area(q) - 2.0 * area(r);
		cout.width(8);
		cout << fixed << setprecision(2) << ans;
	}
	cout << endl;
	return 0;
}

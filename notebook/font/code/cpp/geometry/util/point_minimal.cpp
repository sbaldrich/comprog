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


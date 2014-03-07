Point intersection(const Point &p, const Point &q, const Point &r,
		   const Point &s) {
  Point a = q - p, b = s - r, c = Point(p ^ q, r ^ s);
  return Point(Point(a.x, b.x) ^ c, Point(a.y, b.y) ^ c) / (a ^ b);
}


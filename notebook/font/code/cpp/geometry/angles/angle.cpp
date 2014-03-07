inline double angle(const Point &p, const Point &q, const Point &r) {
  Point u = p - r, v = q - r;
  return atan2(u ^ v, u * v);
}

bool polar_comp(const Point &p, const Point &q) {
  Point P = p - Point::pivot, Q = q - Point::pivot;
  int q1 = Quadrant(P), q2 = Quadrant(Q);
  if (q1 != q2) return q1 < q2;
  double R = P ^ Q;
  if (::cmp(R)) return R > 0;
  return ::cmp(P * P, Q * Q) < 0;
}

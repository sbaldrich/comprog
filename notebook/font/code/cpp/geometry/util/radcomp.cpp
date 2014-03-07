bool radial_comp(const Point &p, const Point &q) {
  Point P = p - Point::pivot, Q = q - Point::pivot;
  double R = P ^ Q;
  if (::cmp(R)) return R > 0;
  return ::cmp(P * P, Q * Q) < 0;
}

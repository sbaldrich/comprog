inline int turn(const Point &p, const Point &q, const Point &r) {
  return ::cmp((p - r) ^ (q - r));
}

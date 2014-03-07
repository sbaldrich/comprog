inline bool between(const Point &p, const Point &q, const Point &r) {
  return turn(p, r, q) == 0 && ::cmp((p - r) * (q - r)) <= 0;
}

int quadrant(const Point &p) {
  if (::cmp(p.x) == 0 && ::cmp(p.y) == 0) return 5;
  if (::cmp(p.y) == 1) {
    if (::cmp(p.x) == 1) return 1;
    return 2;
  }
  if (::cmp(p.y) == 0) {
    if (::cmp(p.x) == 1 || ::cmp(p.x) == 0) return 1;
    return 3;
  }
  if (::cmp(p.x) == -1) return 3;
  return 4;
}


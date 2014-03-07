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


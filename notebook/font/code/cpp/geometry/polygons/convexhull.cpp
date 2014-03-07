vector <Point> convex_hull(vector <Point> T) {
  int j = 0, k, n = T.size(); vector <Point> U(n);
  Point::pivot = *min_element(T.begin(), T.end());
  sort(T.begin(), T.end(), RadialComp);
  for (k = n - 2; k >= 0 && turn(T[0], T[n - 1], T[k]) == 0; --k);
  reverse((k + 1) + T.begin(), T.end());
  for (int i = 0; i < n; ++i) {
    // Change >= for > to keep the colinear points.
    while (j > 1 && turn(U[j - 1], U[j - 2], T[i]) > 0) --j;
    U[j++] = T[i];
  }
  U.erase(j + U.begin(), U.end());
  return U;
}


double Point :: distance(const Point &p1, const Point &p2,
		  const bool &isSegment) const {
    double dist = ((p2 - p1) ^ (*this - p1)) / p2.distance(p1);
    if (isSegment) {
      double dot1 = (*this - p2) * (p2 - p1);
    if (::cmp(dot1) > 0) return sqrt((p2 - *this) * (p2 - *this));
      double dot2 = (*this - p1) * (p1 - p2);
    if (::cmp(dot2) > 0) return sqrt((p1 - *this) * (p1 - *this));
	}
    return abs(dist);
}

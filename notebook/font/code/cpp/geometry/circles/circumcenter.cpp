/*
 * Returns the circumcenter of the triangle formed by the given points.
 * If the points are collinear returs shit.
 */
Point circumcenter(Point p, Point q, Point r){
	Point a = p-r, b = q-r, c = Point(a * (p + r) /2, b * (q+r) /2);
	return Point(c ^ Point(a.y, b.y), Point(a.x, b.x) ^ c ) / (a ^ b);
}


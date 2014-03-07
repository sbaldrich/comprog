double Point :: distance(const Point &o) const{
    double d1 = x - o.x, d2 = y - o.y;
    return sqrt(d1 * d1 + d2 * d2);
}


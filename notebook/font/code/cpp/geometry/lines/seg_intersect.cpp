bool seg_intersect(Point p, Point q, Point r, Point s){
	Point A = q - p, B = s - r, C = r - p, D = s - q;
	int a = cmp(A ^ C) + 2 * cmp(A ^ D);
	int b = cmp(B ^ C) + 2 * cmp(B ^ D);
	if( a == 3 || a == -3 || b == 3 || b == -3) return false;
	if( a || b || p == r || p == s || q == r || q == s) return true;
	int t = (p < r) + (p < s) + (q < r) + (q < s);
	return t != 0 && t != 4;
} 


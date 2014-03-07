/*
 * Points in both polygons should be ordered clockwise.
 * Remember to use radial_comp before using this method.
 */

polygon poly_intersect(polygon &P, polygon &Q){
	int m = Q.size(), n = P.size();
	int a = 0, b = 0, aa = 0, ba = 0, inflag = 0;
	polygon R;
	while( (aa < n || ba < m) && aa < 2*n && ba < 2*m){
		Point p1 = P[a], p2 = P[(a+1) % n], q1 = Q[b], q2 = Q[(b+1) % m];
		Point A = p2 - p1, B = q2 - q1;
		int cross = cmp(A ^ B), ha = turn(p2, q2, p1), hb = turn(q2, p2, q1);
		if(cross == 0 && turn(p1, q1, p2) == 0 && cmp(A * B) < 0){
			if(between(p1, q1, p2)) R.push_back(q1);
			if(between(p1, q2, p2)) R.push_back(q2);
			if(between(q1, p1, q2)) R.push_back(p1);
			if(between(q1, p2, q2)) R.push_back(p2);
			if(R.size() < 2) return polygon();
			inflag = 1; break;
		}else if(cross != 0 && seg_intersect(p1, p2, q1, q2)) {
			if(inflag == 0) aa = ba = 0;
			R.push_back(intersection(p1, p2, q1, q2));
			inflag = (hb > 0) ? 1 : -1;
		}
		if(cross == 0 && hb < 0 && ha < 0) return R;
		bool t = cross == 0 && hb == 0 && ha == 0;
		if(t ? (inflag == 1) : (cross >= 0) ? (ha <= 0) : (hb > 0)){
			if(inflag == -1) R.push_back(q2);
			ba++; b++; b %= m;
		}else{
			if(inflag == 1) R.push_back(p2);
			aa++; a++; a %= n;
		}
	}

	if(inflag == 0){
		if (in_polygon(P[0], Q)) return P;
		if (in_polygon(Q[0], P)) return Q;
	}
	R.erase(unique(R.begin(), R.end()), R.end());
	if(R.size() > 1 && R.front() == R.back()) R.pop_back();
	return R;
}


typedef pair<Point, double> circle;

bool in_circle(circle C, Point p){
	return cmp(abs(p - C.first), C.second) <= 0;
}

circle spanning_circle(vector<Point> &T){
	int n = T.size();
	random_shuffle(T.begin(),T.end());
	circle C(Point(), -oo);
	for(int i=0;i<n;i++) if(!in_circle(C,T[i])){
		C = circle(T[i],0);
		for(int j=0; j<i; j++) if (!in_circle(C, T[j])){
			C = circle((T[i] + T[j] ) / 2, abs(T[i] - T[j]) / 2);
			for(int k=0; k<j; k++) if(!in_circle(C,T[k])){
				Point o = circumcenter(T[i], T[j], T[k]);
				C = circle(o, abs(o - T[k]));
			}
		}
	}
	return C;
}


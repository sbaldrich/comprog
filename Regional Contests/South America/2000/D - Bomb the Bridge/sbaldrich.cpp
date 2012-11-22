/*
 * sbaldrich.cpp
 *
 *  Created on: 06/11/2011
 *  Author: sbaldrich
 */
#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

// Comparison function required to compare points with double coordinates.
const double EPS = 1e-10;

inline int cmp(double x, double y = 0, double tol = EPS) {
	return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}

struct Point {

	Point(double x_ = 0.0, double y_ = 0.0) :
			x(x_), y(y_) {
	}

	Point operator +(const Point &o) const {
		return Point(x + o.x, y + o.y);
	}
	Point operator -(const Point &o) const {
		return Point(x - o.x, y - o.y);
	}
	Point operator *(const double &m) const {
		return Point(m * x, m * y);
	}
	Point operator /(const double &m) const {
		return Point(x / m, y / m);
	}
	double operator *(const Point &o) const {
		return x * o.x + y * o.y;
	}
	double operator ^(const Point &o) const {
		return x * o.y - y * o.x;
	}

	int cmp(Point o) const {
		if (int t = ::cmp(x, o.x))
			return t;
		return ::cmp(y, o.y);
	}
	bool operator ==(const Point &o) const {
		return cmp(o) == 0;
	}
	bool operator !=(const Point &o) const {
		return cmp(o) != 0;
	}
	bool operator <(const Point &o) const {
		return cmp(o) < 0;
	}

	double Distance(const Point &o) const {
		double d1 = x - o.x, d2 = y - o.y;
		return sqrt(d1 * d1 + d2 * d2);
	}

	double Distance(const Point &p1, const Point &p2,
			const bool &isSegment) const {
		double dist = ((p2 - p1) ^ (*this - p1)) / p2.Distance(p1);
		if (isSegment) {
			double dot1 = (*this - p2) * (p2 - p1);
			if (::cmp(dot1) > 0)
				return sqrt((p2 - *this) * (p2 - *this));
			double dot2 = (*this - p1) * (p1 - p2);
			if (::cmp(dot2) > 0)
				return sqrt((p1 - *this) * (p1 - *this));
		}
		return abs(dist);
	}

	friend ostream& operator <<(ostream &o, Point p) {
		return o << "(" << p.x << ", " << p.y << ")";
	}

	double x, y;
	static Point pivot;
};

Point Point::pivot(0, 0);

struct line {
	Point A, B;
	line(Point A, Point B) :
			A(A), B(B) {
	}

};

struct circle {
	Point c;
	double r;
	circle(){}
	circle(Point p, double r) :
			c(p), r(r) {
	}

	bool intersects(circle &C) {
		return (this->c.Distance(C.c) <= (this->r + C.r));
	}
	bool inside(circle &C) {
		return (this->c.Distance(C.c) + this->r < C.r);
	}
	friend ostream& operator<<(ostream& o, circle c) {
		return (o << "{ " << c.c << " - " << c.r << " }");
	}
};

int useful(circle &C, line &L, line &R) {
	bool left = false, right = false;
	double toleft = C.c.Distance(L.A, L.B, true) , toright =C.c.Distance(R.A, R.B, true) ;
	//cout << C << endl;
	//cout << "toleft: "<<toleft<<endl<<"toright: "<<toright << endl;
	if (C.c.Distance(L.A, L.B, true) <= C.r) {
		left = true;
	}
	if (C.c.Distance(R.A, R.B, true) <= C.r) {
		right = true;
	}
	if (left && right)
		return 2;
	if (left)
		return -1;
	if (right)
		return 1;
	return 0;
}

int main() {
	//freopen("D.in", "r", stdin);
	int n,b;
	int w, l, x, y, r;
	cin >> n;
	vector<circle> circles;
	for (int z = 0; z < n; z++) {
		circles.clear();
		cin >> w >> l >> b;
		line Left(Point(), Point(0, l));
		line Right(Point(w, 0), Point(w, l));
		for (int i = 0; i < b; i++) {
			cin >> x >> y >> r;
			circles.push_back(circle(Point(x, y), r));
		}

		/*for (int i = 0; i < b; i++)
			cout << circles[i] << endl;*/

		vector<int> dSet(b, -1);
		int sets = 0;
		for (int i = 0; i < b; i++) {
			circle C = circles[i];
			bool any = false;
			for (int j = i + 1; j < b; j++) {
				circle X = circles[j];
				if (C.intersects(X)) { //Found a place for it

					if (dSet[i] == -1 && dSet[j] == -1)
						dSet[i] = dSet[j] = sets++;
					else if (dSet[i] != -1 && dSet[j] != -1)
						dSet[i] = dSet[j] = min(dSet[i], dSet[j]);
					else
						dSet[i] = dSet[j] = (dSet[i] != -1 ? dSet[i] : dSet[j]);
					any = true;
				}
			}
			if (!any && dSet[i] == -1) {
				dSet[i] = sets++;
			}
		}
		/*cout << "**Sets**"<<endl;
		for (int i = 0; i < b; i++)
			cout << dSet[i] << " ";
		cout <<endl<<"-"<< endl;*/
		vector<int> edge(sets , 0);
		int aux;
		bool split = false;
		for (int i = 0; i < sets; i++) {
			//cout << "**"<<i<<endl;
			for (int j = 0; j < b; j++) {
				//cout << "edge[" << i <<"] : " <<edge[i]<<endl;
				if (dSet[j] == i) {
					if ((aux = useful(circles[j], Left, Right)) != 0) {
						//cout << circles[j]<<"->" << aux << endl;
						if(aux == 2)
						{
							split = true;
							break;
						}
						if (edge[i] != 0) {
							if (edge[i] != aux) {
								edge[i] = 2;
								split = true;
								break;
							}
						}
						edge[i] = aux;
					}
				}
			}
			if (split)
				break;
		}
		if (split) {
			cout << "Bridge already split" << endl;
			continue;
		}
		/*cout << "**edges**"<<endl;
		for(int i=0;i<sets-1;i++)
			cout << edge[i]<<" ";
		cout << endl<<"-"<<endl;*/
		double minimumDistance = w;
		double toLeft, toRight,auxdist;
		for (int i = 0; i < sets; i++) {
			circle C, X;
			if (edge[i] == -1) {
				for (int j = 0; j < b; j++) {
					if (dSet[j] == i) {
						C = circles[j];
						toRight = C.c.Distance(Right.A, Right.B, true) - C.r;
						//cout << "toRight: "<<toRight << endl;
						if (cmp(toRight, minimumDistance) == -1)
							minimumDistance = toRight;

						for(int k=0;k<sets;k++)
						{
							if(edge[k]!=1)
								continue;
							for(int l=0;l<b;l++)
							{
								if(dSet[l]!=k)
									continue;
								X = circles[l];
								auxdist = C.c.Distance(X.c)-(X.r +C.r);
								if (cmp(auxdist, minimumDistance) == -1)
									 minimumDistance = auxdist;
							}
						}
					}
				}

			}
			if (edge[i] == 1) {
				for (int j = 0; j < b; j++) {
					if (dSet[j] == i) {

						C = circles[j];
						toLeft = C.c.Distance(Left.A, Left.B, true)-C.r;
						//cout << "toLeft: "<<toLeft << endl;
						if (cmp(toLeft, minimumDistance) == -1)
							minimumDistance = toRight;

						for(int k=0;k<sets;k++)
						{
							if(edge[k]!=-1)
								continue;
							for(int l=0;l<b;l++)
							{
								if(dSet[l]!=k)
									continue;
								X = circles[l];
								auxdist = C.c.Distance(X.c)-(X.r +C.r);
								if (cmp(auxdist, minimumDistance) == -1)
									 minimumDistance = auxdist;
							}
						}
					}
				}
			}
		}
		cout << ceil(minimumDistance/2)<<endl;

	}
	return 0;
}


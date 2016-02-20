/*
 * Created on: Oct 31, 2011
 * Author: sbaldrich
 * Problem: Move the Water
 * Source: South America Regional Contest 2000
 */

#include<iostream>
#include<vector>
#include<set>
#include<queue>
#include<utility>

#define mp make_pair
#define sc second
#define fs first
#define d(x) cout <<"*"<< #x <<"* -> "<< x << endl;
#define min(a,b) (a)<(b)?(a):(b)
using namespace std;

struct triple {
	int a, b, c;
	triple() {
	}
	triple(int a, int b, int c) :
			a(a), b(b), c(c) {
	}
	bool operator==(const triple &other) const {
		if (a == other.a && b == other.b && c == other.c)
			return true;
		else
			return false;
	}
	friend bool operator<(const triple &d,const triple &t)
	{
		if(d.a < t.a)
			return true;
		else if(d.a == t.a && d.b < t.b)
			return true;
		else if(d.a == t.a && d.b == t.b && d.c < t.c)
			return true;
		return false;
	}

	friend ostream& operator<<(ostream&o, const triple &t) {
		o << "[" << t.a << " " << t.b << " " << t.c << "]";
		return o;
	}
	int total() {
		return (a + b + c);
	}
};

triple a, b, c;
set<triple> visit;
queue<pair<triple, int> > Q;

int bfs(triple start, triple end) {
	visit.clear();
	Q = queue<pair<triple, int> >();
	pair<triple, int> actual;
	triple X;
	Q.push(mp(start, 0));
	int delta;
	while (!Q.empty()) {
		actual = Q.front();
		visit.insert(actual.fs);
		Q.pop();
		if (actual.fs == end)
			return actual.sc;
		X = actual.fs;
		// a -> b
		if (X.b < c.b) {
			delta = min(X.a , (c.b - actual.fs.b));
			X.a -= delta;
			X.b += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
		// b->a
		X = actual.fs;
		if (X.a < c.a) {
			delta = min(X.b , (c.a - actual.fs.a));
			X.b -= delta;
			X.a += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
		// a->c
		X = actual.fs;
		if (X.c < c.c) {
			delta = min(X.a , (c.c - actual.fs.c));
			X.a -= delta;
			X.c += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
		// c->a
		X = actual.fs;
		if (X.a < c.a) {
			delta = min(X.c , (c.a - actual.fs.a));
			X.c -= delta;
			X.a += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
		// b->c
		X = actual.fs;
		if (X.c < c.c) {
			delta = min(X.b , (c.c - actual.fs.c));
			X.b -= delta;
			X.c += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
		// c->b
		X = actual.fs;
		if (X.b < c.b) {
			delta = min(X.c ,(c.b - actual.fs.b));
			X.c -= delta;
			X.b += delta;
			if (!visit.count(X)) {
				Q.push(mp(X, actual.sc + 1));
				visit.insert(X);
			}
		}
	}

	return -1;
}

int main() {
	//freopen("E.in", "r", stdin);
	int x, y, z;
	while (cin >> x && x) {
		cin >> y >> z;
		c = triple(x, y, z);

		cin >> x >> y >> z;
		a = triple(x, y, z);

		cin >> x >> y >> z;
		b = triple(x, y, z);
		if (a.total() != b.total())
			cout << -1 << endl;
		else
			cout << bfs(a, b) << endl;
	}
	return 0;
}


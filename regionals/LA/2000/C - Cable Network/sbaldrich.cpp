/*
 * Created on: Oct 30, 2011
 * Author: sbaldrich
 * Problem: Cable Network
 * Source: South America Regional Contest 2000
 */

#include<iostream>
#include<vector>
#include<limits>

#define min(a,b)	(a)<(b)?(a):(b)

using namespace std;

long long graph[25][25], t;
int n;

const long long oo = numeric_limits<long long>::max();

vector<int> prim(int start, int block) {
	vector<int> parent(n + 1, -1);
	vector<long long> distance(n + 1, oo);
	vector<bool> intree(n + 1, false);

	distance[start] = 0;
	int v = start;
	long long dist;
	for (int i = 0; i <= n; i++) {
		if (block & (1 << i))
			intree[i] = true;
	}

	while (!intree[v]) {
		intree[v] = true;
		for (int i = 0; i <= n; i++) {
			if ((distance[i] > graph[v][i]) && !intree[i])
				distance[i] = graph[v][i], parent[i] = v;
		}

		v = 1;
		dist = oo;
		for (int i = 0; i <= n; i++) {
			if (!intree[i] && dist > distance[i])
				dist = distance[i], v = i;
		}
	}

	return parent;
}

long long price(vector<int> v) {
	long long l = 0LL, b = 0LL;
	for (int i = 0; i <= n; i++)
		if (v[i] != -1)
			l += graph[i][v[i]];
		else
			if(i>0)b++;
	return l + (t * b);
}

int main() {
	int c = 1;
	while (cin >> n && n) {
		cin >> t;
		for (int i = 0; i <= n; i++)
			graph[i][i] = oo;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++)
				cin >> graph[i][j], graph[j][i] = graph[i][j];
		}
		int lim = 1 << (n+1);

		long long best = oo;
		for (int block = 0; block <= lim; block++) {
			long long x = price(prim(0, block));
			best = min(x,best);
		}
		cout << "Cable Net #" << c++ <<endl;
		cout << n*t<<endl<<best<<endl<<endl;


	}

	return 0;
}






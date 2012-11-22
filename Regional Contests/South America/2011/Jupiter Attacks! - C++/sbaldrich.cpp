/*
 * Problem J - Jupiter Attacks!
 *
 * Created on: Mar 1, 2012
 * Segment tree + Modular arithmetic
 */

#include<cstdio>
#include<cmath>
#include<vector>
#include<algorithm>

using namespace std;

int lg(int n)
{
	return log((double)n)/log(2.0);
}

long long powermod(int b, int p, int m) {
	if (p == 0)
		return 1LL;
	else if (p % 2 == 0) {
		long long x = powermod(b, p / 2, m);
		return (x * x) % m;
	} else
		return ((b % m) * powermod(b, p - 1, m)) % m;
}

vector<long long> tree;
int B, N, L;
long long P;

void edit(int node, int l, int r, int pos, int val) {
	if (pos < l || pos > r)
		return;
	if (l == pos && r == pos) {
		tree[node] = val;
		return;
	}
	int m = (l + r) / 2;
	edit(node * 2, l, m, pos, val);
	edit(node * 2 + 1, m + 1, r, pos, val);

	long left = ((tree[2 * node] * (long) powermod(B, r - m, P) % P));
	long right = tree[node * 2 + 1];
	tree[node] = (left + right);
}

long long hash(int node, long l, long r, int i, int j, long offset) {
	if (i > r || j < l)
		return 0;
	if (l >= i && r <= j)
		return (tree[node] % P * (long) powermod(B, offset, P)) % P;

	long m = (l + r) / 2;
	long left = hash(node * 2, l, m, i, j, j - m);
	long right = hash(node * 2 + 1, m + 1, r, i, j, j - r);
	return (left + right) % P;
}

int main() {
	//freopen("j.in" , "r" , stdin);
	tree = vector<long long>( (int)(2*(2<<lg(1e5))+1) , 0LL);
	while (scanf("%d %lld %d %d\n", &B, &P, &L, &N) != -1) {
		if (B == 0 && P == 0 && L == 0 && N == 0)
			break;
		char op;
		int arg1 , arg2;
		fill(tree.begin(), tree.end() ,0LL);
		for(int i=0;i<N;i++)
		{
			scanf("%c %d %d\n" , &op , &arg1, &arg2);
			if(op == 'E')
				edit(1,1,L,arg1,arg2);
			else
				printf("%lld\n" , hash(1,1,L,arg1,arg2,0));
		}
		printf("-\n");
	}
	return 0;
}


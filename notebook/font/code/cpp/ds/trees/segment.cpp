/*
	Segment Tree implementation.
	Remember to call all functions with 0-based indexes!
	Did I say you should call all functions with 0
	(ZERO ZEEEERO) based indexes?
*/

#define M 100000
#define left(x) (2*x+1)
#define right(x) (2*x+2)

int a[M];
int tree[4*M + 1]; //Yup, no lg's or anything. 4*M.

void init(int node, int l, int r){
	if(l == r){
		tree[node] = a[l];
		return;	
	}
	int m = (l + r)>> 1;
	init(left(node), l, m);
	init(right(node), m+1,r);

	tree[node] = tree[left(node)] * tree[right(node)];
}

int query(int node, int l, int r, int p, int q){
	if(q < l || r < p) return 1; //The identity value.
	if(p<=l && r <= q)
		return tree[node];
	int m = (l + r)>> 1;
	return query(left(node), l, m, p, q) * query(right(node), m+1, r, p, q);
}

void update(int node, int l, int r, int p, int val){
	if(p < l || r < p)return;
	if(l == r){
		tree[node] = val;
		return;
	}
	int m = (l + r) >> 1;
	update(left(node), l, m, p, val);
	update(right(node), m+1, r, p, val);
	tree[node] = tree[left(node)] * tree[right(node)];
}


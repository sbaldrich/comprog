#include<cstdio>
#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

#define M 100000
#define left(x) (2*x+1)
#define right(x) (2*x+2)

int a[M];
int tree[4*M + 1];

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

int f(int val){
	return val < 0 ? -1 : val == 0 ? 0 : 1;
}

int main(){
	freopen("i.in" , "r" , stdin);
	//freopen("i.out" ,"w" , stdout);
	for(int n,k;cin>>n>>k;){
		for(int i=0,x;i<n;i++){
			cin>>x;
			a[i] = f(x);
		}
		init(0,0,n-1);
		for(int i=0;i<k;i++){
			char o;
			int p,q;
			cin>>o>>p>>q;
			if(o =='C')
				update(0,0,n-1,p-1,f(q));
			else{
				int x = query(0,0,n-1,p-1,q-1);
				cout << (x==0?'0':x<0?'-':'+');
			}
		}
		cout << endl;
	}

}

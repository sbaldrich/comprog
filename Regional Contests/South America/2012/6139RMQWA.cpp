#include<cstdio>
#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

#define left(x) (x<<1)
#define right(x) ((x<<1)+1)
#define max(x,y) (x>y?x:y)

const int M = 1000000;

struct Node
{
	Node(){left = right = 0;}
	int left, right;
	int value;
	friend ostream& operator<<(ostream &o, Node &n){
		return o << "( " << n.value << ", [" << n.left << ", "<< n.right << "])" ;
	}
};

vector<Node> tree;

void init_node(int left , int right, int node=1){
	Node &n = tree[node];
	n.left  = left;
	n.right = right;
	n.value = 1;
	//cout << n.left << " - " << n.right << " - " << n.value << endl;
	if(left < right){
		int mid = (left + right) >> 1;
	//	cout << left(node) << " - " << right(node) << endl;
		
		init_node(left , mid , left(node));
		init_node(mid+1, right, right(node));
	}
}

int update(int pos, int val, int node = 1){
	Node &n = tree[node];
	if(pos < n.left || pos > n.right)return n.value;
	if(pos == n.left && pos == n.right) return n.value = val;
	int dr = update(pos,val, right(node));
	int dl = update(pos,val, left(node));
	return n.value = dr*dl;
}

int query(int l, int r, int node=1){
	Node &n = tree[node];
	if(l < n.left || r > n.right) return 1;
	if(l <= n.left && n.right <= r) return n.value;
	int dr = query(l,r,right(node));
	int dl = query(l,r,left(node));
	return dr*dl;
}

void d(int l){
	for(int i=1;i<=l;i++)
		cout << ((i>1)?", ":"") << tree[i];
	cout << endl;
}

/*int main(){
	init_node(1,5);
	update(1,10);
	update(5,11);
	d(9);
	cout << query(1,1) << endl;
	cout << query(1,5) << endl;
	cout << query(4,5) << endl;
	return 0;
}*/



int main(){
	freopen("i.in" , "r" , stdin);
	freopen("i.out" ,"w" , stdout);
	int N , K, x, l, r;
	char c;
	bool line = false;
	while(cin>>N>>K){
		if(line)
			cout << endl;
		tree.clear();
		tree = vector<Node> (5*M, Node());
		init_node(1,N);
		for(int i=0;i<N;i++){
			cin>>x;
			update(i+1, x == 0? 0 : x<0? -1 : 1);
			//update(i+1, x);
		}
///		for(int i=0;i<=10;i++)
//			cout<< tree[i].value << " ";
//		cout << endl;
//
//		cout << "1 4 " << query(1,4) << endl;
//		cout << "1 1 " << query(1,1) << endl;
//		
//		for(int i=0;i<=10;i++)
//			cout<< tree[i].value << " ";
//		cout << endl;
//		cout << "2 2 " << query(2,2) << endl;
//
//		cout << "3 3 " << query(3,3) << endl;
//		cout << "4 4 " << query(4,4) << endl;
//		cout << "2 4 " << query(2,4) << endl;
//		cout << "3 4 " << query(3,4) << endl;
		while(K--){
			cin>>c >> l >>r;
			if(c == 'C')
				update(l,r);
			else {
				int y = query(l,r);
				if(y>0)
					cout << "+";
				else if(y<0)
					cout << "-";
				else cout << "0";
			}
		}
		line = true;
	}
}

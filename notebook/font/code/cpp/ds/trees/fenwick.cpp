//Lowbit function. Helps determine dependent and responsible nodes.
int lb(int i){
	return (i & -i);
}
//Get the prefix sum [1 - idx]. If sum [i , j] is necessary, 
//use as get(j) - get(i-1)
int get(int *tree, int idx){
	int s = 0;
	for(int i=idx;i;i-=lb(i)) s += tree[i];
	return s;
}
//Update a value on the tree and let responsible nodes
//know about the change
void update(int *tree, int idx, int val){
	for(int i=idx;i<M;i+=lb(i))tree[i] += val;
}



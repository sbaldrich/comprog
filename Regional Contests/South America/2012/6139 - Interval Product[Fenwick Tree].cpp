#include<iostream>
#include<cstring>

using namespace std;

const int M = 10050;
int v[M],n[M],z[M];

int lb(int i){
	return (i & -i);
}

int get(int *tree, int idx){
	int s = 0;
	for(int i=idx;i;i-=lb(i)) s += tree[i];
	return s;
}

void update(int *tree, int idx, int val){
	for(int i=idx;i<M;i+=lb(i))tree[i] += val;
}


int main(){
	//freopen("int.in" , "r", stdin);

	int N,K;
	while(cin>>N>>K){
		memset(n, 0, sizeof(n));
		memset(z, 0, sizeof(n));
		for(int i=1;i<=N;i++){
			cin>>v[i];
			if(v[i] < 0)
				update(n, i, 1);
			else if(!v[i]) update(z,i,1);
		}
		char o;
		int a,b;
		for(int i=0;i<K;i++){
			cin>>o>>a>>b;
			if(o == 'C'){
				if(v[a] < 0)
					update(n,a,-1);
				else if(!v[a]) update(z,a,-1); 
				v[a] = b;
				if(v[a] < 0)update(n,a,1);
				else if(!v[a]) update(z,a,1); 
			}

			else{
				int zz = get(z,b) - get(z,a-1);
				int nn = get(n,b) - get(n,a-1);
				cout << (zz?'0':(nn & 1)?'-':'+');  
			}
		}
		cout << endl;
	}

	return 0;
}

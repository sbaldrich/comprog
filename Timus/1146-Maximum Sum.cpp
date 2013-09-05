#include<cstdio>
#include<cstring>

using namespace std;

#define max(a,b) (a) > (b) ? (a) : (b)

const int NN = 128;
int M[NN][NN];
int T[NN];

void dump(int *a, int n=4){
	for(int i=0;i<n;i++)
		printf("%3d", a[i]);
	puts("");

}

int kadane(int *a, int n){
	int gs = 1<<31,cs=0;
	for(int i=0;i<n;i++){
		cs+=a[i];
		if(cs < 0)
			cs = 0;
		if(cs > gs)
			gs = cs;
	}
	return gs;
}

int main(){
	freopen("1146.in" , "r", stdin);
	for(int n;scanf("%d", &n)==1;){
		int pos = 1<<31;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				scanf("%d", &M[i][j]);
				pos = max(pos, M[i][j]);
			}
		
		if(pos < 0){
			printf("%d\n", pos);
			continue;
		}
			
		int best = 1<<31;

		for(int k=0;k<n;k++){
			memset(T,0,sizeof(int)*n);
			for(int i=k;i<n;i++){
				for(int j=0;j<n;j++)
					T[j]+=M[i][j];
				best = max(best,kadane(T,n));	
			}
		}
		printf("%d\n" , best);
	}

	return 0;
}

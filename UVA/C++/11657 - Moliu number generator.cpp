#include<cstdio>
#include<cstring>
#include<map>
#include<algorithm>

using namespace std;

#define present(c,x) (c).find(x)!=(c).end()

map<long long, int> M;

int f(long long n){
	//printf("f(%d)\n", n);
	if(present(M,n))
		return M[n];
	if(n <= 3)
		return n;
	if(!n)
		return 0;
	if(n%2 == 0)
		return M[n] = f(n/2) + 1;
	int l = f(n-1), r = f(n+1);
	//printf("n = %d -> l:%d, r:%d\n", n, l, r);
	return M[n] = min(f(n-1), f(n+1)) + 1;
}

int main(){
	int n;
	while(scanf("%d" , &n))
		printf("%d\n" , f((long long)n));
	return 0;
}

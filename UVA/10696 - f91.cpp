#include<cstdio>

using namespace std;


int f91(int n){
	if(n>100)
		return n-10;
	return 91; 
}

int main(){
	int x;
	while(scanf("%d",&x) && x){
		printf("f91(%d) = %d\n", x, f91(x));
	}
	return 0;
}

/*
	f(91) = f(f(102)) = f(92) = f(f(103)) = f(93) = f(f(104)) = f(94) = -> f(101) = 91
*/


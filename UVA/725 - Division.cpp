/*
 * This problem is bullshit. The output formatting is just stupid. Moving on.
 */

#include<cstdio>
#include<cstring>

using namespace std;

inline bool valid(int x, int y){
	if( x > 9999 && y > 9999)
		return false;
	int c[10];
	memset(c, 0 ,sizeof c );
	c[0] = 1;
	while(y){
		c[y%10]++;
		y/=10;
	}	
	while(x){
		c[x%10]++;
		x/=10;
	}	
	for(int i=0;i<10;i++)
		if(c[i] != 1)
			return false;
	return true;
} 

int main(){
	int x , y, n, m = 0;
	bool f = true;
	while(scanf("%d", &n) == 1 && n){
		if(!f || m != n && m != 0)
			puts("");
		f = false;
		m = n;
		for(y = 1234; y<= 98765; y++){
			x = y * n;
			if( valid( x, y ) ){
				f = true;
				printf("%05d / %05d = %d\n" , x,y,n);
			}
		}
		if(!f)
			printf("There are no solutions for %d.\n" , n);
	}
	return 0;
}

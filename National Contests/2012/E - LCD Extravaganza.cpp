#include<cstdio>
#include<string>
#include<algorithm>

using namespace std;

const int NN = 10048;
int s[NN],d[NN],f[NN];

string base[] = {"._.|.||_|", ".....|..|" , "._.._||_.",
				"._.._|._|", "...|_|..|", "._.|_.._|",
				"._.|_.|_|", "._...|..|", "._.|_||_|", "._.|_|._|"};


char get_c(int offset, int y, int d, int f){
	string &s = base[d];
	string r1 = s.substr(0,3),
		   r2 = s.substr(3,3),
		   r3 = s.substr(6,3);
	if(y > 2*f)
		return '.';
	if(y == 0)
		return offset == f+1 ? r3[0] : offset == 0 ? r3[2] : r3[1];
	if(y < f)
		return offset == f+1 ? r3[0] : offset == 0 ? r3[2] : '.';
	if(y == f)
		return offset == f+1 ? r2[0] : offset == 0 ? r2[2] : r2[1];
	if(y < 2*f)
		return offset == f+1 ? r2[0] : offset == 0 ? r2[2] : '.';
	else 
		return offset == f+1 ? r1[0] : offset == 0 ? r1[2] : r1[1];
}

int main(){
	freopen("E.in" , "r", stdin);
	for(int n,q;scanf("%d", &n) && n;){
		for(int i=0;i<n;i++){
			scanf("%d %d" , &d[i], &f[i]);
			if(!i)s[i] = f[i]+1;
			else s[i] = s[i-1] + f[i] + 3;
		}
		scanf("%d" , &q);
		for(int i=0,x,y;i<q;i++){
			scanf("%d %d" , &x, &y);
			int c = (lower_bound(s, s+n, x) - s);
			if(c && s[c-1] + 1 == x)
				printf(".\n");
			else printf("%c\n", get_c(s[c]-x, y, d[c],f[c]));
		}
			
	}
	return 0;
}

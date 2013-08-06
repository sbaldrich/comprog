#include<iostream>
#include<string>
#include<cstring>
#include<algorithm>

using namespace std;

int M[0x1001];

bool check(const int &n,int bit){
	return n & (1<<bit);
}
void toogle(int &n, int bit){
	n^=1<<bit;
}

int toi(string s){
	int r = 0;
	for(int i=0;i<s.size();i++)
		if(s[i]=='o')
			r|=(1<<(s.size()-1-i));
	return r;
}
int f(int n){
	if(M[n])
		return M[n];
	int m = __builtin_popcount(n),x;
	for(int i=0;i<12;i++){
		if(check(n,i)){
			if(i>1){
				if(!check(n,i-2) && check(n,i-1)){
					x = n;
					toogle(x,i-1);
					toogle(x,i-2);
					toogle(x,i);
					m = min(m,f(x));
				}
			}
			if(i<10)
				if(!check(n,i+2) && check(n,i+1)){
					x = n;
					toogle(x,i+1);
					toogle(x,i+2);
					toogle(x,i);
					m = min(m,f(x));
				}
		}
	}
	
	return M[n] = m;
}

int main(){
	int c;
	cin>>c;
	string str;
	while(c--){
		cin>>str;
		cout << f(toi(str))<<endl;
	}
	return 0;
}

#include<iostream>
#include<cstdio>

using namespace std;

int main(){
	freopen("aa.in" , "r", stdin);	
	int H,U,D,F,d;
	double f,p,dd;
	bool success;;
	while(cin >> H >> U >> D >> F && H){
		f = p = 0.0;
		d = 0;
		f = F * U / 100.0;
		while(true){
			dd =U - f*d;
			if(dd > 0)
				p += dd;
			d++;
			if(p > H){
				success = true;
				break;
			}
			p -= D;
			//cout << d << " " << p << " " << endl;
			if(p < 0){
				success = false;
				break;
			}
		}
		if(p <= 0)
			cout << "failure on day " << d << endl;
		else cout << "success on day " << d << endl;
	}
	return 0;
}

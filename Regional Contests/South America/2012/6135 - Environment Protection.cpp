#include<iostream>
#include<iomanip>


using namespace std;

double W,D,A,K;
double p1[10],q1[10],p2[10],q2[10];
double EPS = 1e-4;

double f(double x, double cut){
	double n1,n2,d1,d2; //Horner's rule. Thanks to afruizc for his post on this.
	n1 = n2 = d1 = d2 = 0.0;
	for(int i=K;i>=0;i--){
		n1 = n1 * x + p1[i];
		d1 = d1 * x + q1[i];
		n2 = n2 * x + p2[i];
		d2 = d2 * x + q2[i];
	}
	double f1 = n1/d1 , f2 = n2/d2;

	if(f1 <= cut)
		return 0;
	else if(cut < f2)
		return f1 - f2;
	else return f1 - cut;
}

double simpson(double a, double b, double x){
	double fa,fab,fb;
	fa = f(a,x);
	fab = f((a+b)/2.0, x);
	fb = f(b,x);
	double r = ((b-a)/6.0) * (f(a,x) + (4*f((a+b)/2.0,x)) + f(b,x));
	return r; 
}

int main(){
	freopen("E.in" , "r" , stdin);

	while(cin>> W >> D >> A >> K){
		for(int i=0;i<=K;i++)
			cin>>p1[i];
		for(int i=0;i<=K;i++)
			cin>>q1[i];
		for(int i=0;i<=K;i++)
			cin>>p2[i];
		for(int i=0;i<=K;i++)
			cin>>q2[i];
		double lo = -D, hi = 0.0;
		for(int i=0;i<25;i++){
			double m = (lo + hi)/2.0;
			double act_area = 0.0;
			for(double a=0.0; a+EPS-1e-5<W ; a+=EPS){
				act_area += simpson(a, a+EPS,m);
			}
			if(act_area < A)
				 hi = m;
			else lo = m; 
		
		}
		cout <<fixed <<  setprecision(5) << -lo << endl;
	}
	return 0;
}

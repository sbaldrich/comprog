#include <cmath>
#include <cstdio>
using namespace std;

double dist(double x1, double y1, double x2, double y2){
	return sqrt((x2-x1) * (x2-x1) + (y2-y1)*(y2-y1));
}

int main(){
	freopen("cc.in" , "r", stdin); 
	double PI = 3.141592653589793;
	double x1,y1,x2,y2,x3,y3;
	while((scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &x3, &y3) == 6)){
		double a,b,c,s;
		a = dist(x1,y1,x2,y2);
		b = dist(x2,y2,x3,y3);
		c = dist(x3,y3,x1,y1);
		s = (a+b+c)/2;
		double d = (a*b*c)/sqrt(s*(s-a)*(s-b)*(s-c))/2.0;
		printf( "%.2f\n",PI*d); 
	}
	return 0;
}


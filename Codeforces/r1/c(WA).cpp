#include<iostream>
#include<cmath>
#include<cstdio>
using namespace std;

const double oo = 1e16;
struct Point
{
	Point(double a=0.0, double b=0.0) : x(a), y(b) {}
	double x, y;	
	
	double distance(Point q)
	{
		return sqrt((q.x - x) * (q.x - x) + (q.y - y) * (q.y - y));
	}
	
	friend ostream& operator << (ostream& o, Point &p){
		return o << "(" << p.x << ", " << p.y << ")";  
	}
};

struct Line
{
	Line(double a=0.0 , double b=0.0 , double c=0.0) : a(a), b(b), c(c) {}
	Line(Point p , Point q)
	{
		a = q.y - p.y;
		b = p.x - q.x;
		c = a*p.x + b*p.y;
	}
	double a,b,c;
	friend ostream& operator <<(ostream &o, Line l) {
                return o << "[" << l.a << ", " << l.b << ", " << l.c << "]";
        }
	Point intersect(Line o)
	{
		double det = a * o.b  - o.a*b;
		if(det == 0)
		{
			return Point(oo,oo);
		} 
		double x = (c * o.b - o.c * b) / det; 
		double y = (a*o.c - o.a * c) / det;
		return Point(x,y);
	}
	Line perpendicular(Point p)
	{
		return Line(-b , a, -b*p.x + a*p.y);
	}
	
};

struct Circle
{
	Point center;
	double r;
	
	friend ostream& operator << (ostream& o , Circle &c)
	{
		return o << "C{" << c.center << " r= " << c.r << "}";
	}
};

Circle circle_from_points(Point p , Point q , Point r)
{
	Line P[2];
	P[0] = Line(p,q).perpendicular(Point((p.x + q.x)/2.0 , (p.y + q.y)/2.0));
	P[1] = Line(q,r).perpendicular(Point((r.x + q.x)/2.0 , (r.y + q.y)/2.0));
	Circle c;
	c.center = Point(P[0].intersect(P[1]));
	c.r = c.center.distance(p);
	return c;  
}

const double PI = acos(-1);
const double eps = 1e-9;

int main()
{
	freopen("c.in" , "r" , stdin);
	double x,y;
	Point p[3];
	Line lines[2];
	for(int i=0;i<3;i++)
		cin>>x >> y,p[i] = Point(x,y);
	Circle c = circle_from_points(p[0], p[1] , p[2]);
	//cout << c << endl;
	int n = 3;
	bool done = false;
	double a[3];
	
	for(int i=0;i<3;i++)
		a[i] = atan2(p[i].y - c.center.y , p[i].x - c.center.x), cout << a[i] * 180 / PI<< endl;
	
	for(;n<100 && !done;++n)
	{
		cout << n << endl;
		done = true;
		for(int i=0;i<3;i++)
			for(int j=i+1;j<3;j++)
			{
				double alpha = 2*PI/(double)n, theta = a[i] , beta=a[j];
				printf("th: %.10f , beta: %.10f\n" , theta, beta);
				double r = fmod(fabs(theta - beta),alpha);
				printf("%.10f\n" , r);
				done &= r < eps;
				
			}
	if(done)
		break;
			
	}
	cout << n << endl; 
	double alpha = 2 * PI / (double)n;
	double A = 0.5 * n * c.r * c.r * sin(alpha);
	printf("%.10f\n" , A);

	return 0; 
}

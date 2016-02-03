import static java.lang.Math.*;
import java.util.*;
import java.text.DecimalFormat;

public class AncientBerlandCircus{

  static final double EPS = 1e-4;
  static final DecimalFormat df = new DecimalFormat("0.000000");
  static double dist(double x1, double y1, double x2, double y2){
    return sqrt( (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) );
  }

  static double gcd(double a, double b){
    while(abs(a) > EPS && abs(b) > EPS){
      if(a > b)
        a -= floor(a / b) * b;
      else
        b -= floor(b / a) * a;
    }
    return a + b;
  }

  public static void main(String[] args){
    double x1, x2, x3, y1, y2, y3;
    Scanner sc = new Scanner( System.in );
    x1 = sc.nextDouble();  y1 = sc.nextDouble();
    x2 = sc.nextDouble();  y2 = sc.nextDouble();
    x3 = sc.nextDouble();  y3 = sc.nextDouble();

    double a, b, c, s, S, R, A, B, C;
    // s: Heron's formula s to find the area of a triangle
    // S: Triangle area
    // R: Circumradius
    // a, b, c: triangle sides
    // A, B, C: Angles. Obtained from cosine law
    a = dist(x2, y2, x3, y3);
    b = dist(x1, y1, x3, y3);
    c = dist(x1, y1, x2, y2);

    s = (a + b + c) / 2.0;
    S = sqrt(s * (s - a) * (s - b) * (s - c) );
    R = a * b * c / (4.0 * S);
    A = acos((b * b + c * c - a * a) / (2.0 * b * c) );
    B = acos((a * a + c * c - b * b) / (2.0 * a * c) );
    C = acos((a * a + b * b - c * c) / (2.0 * a * b) );
    //n is the number of sides in the regular polygon we are looking for
    double n = PI / gcd( gcd( A, B ), C );
    double area = n * R * R * sin(2 * PI / n) / 2.0;
    System.out.println(df.format(area));
  }

}

#include<bits/stdc++.h>

using namespace std;

int main(){
	int T;
	double C, F, X, q, qq, K;
	cin >> T;
	for( int caze=1; caze <= T;  caze++ ){
		cin  >> C >> F >> X;
		double tt = 0.0, next_farm, K = 0.0, q=2.0;
		while( true ){
			//printf("q = %.2f  time = %.4f\n", q, tt ); 
			next_farm = C / q;
			//printf("next farm in %.3f\n", next_farm);
			double xx = next_farm + (X - C) / q;
			double qq = q + F;
			double yy = next_farm + X / qq;
			//printf("Buying the farm, the total time would be %.3f\n", yy);
			//printf("Not buying the farm, the total time would be %.3f\n", yy);
			if( xx < yy ){
				tt += xx;
				break;
			}
			else{
				tt+=next_farm;
				q = qq;
			}
		}
		printf("Case #%d: %.7f\n", caze, tt);
		
	}
	return 0;
}

/*
 *	Find the lowest non-negative solution to a*x = b(mod m)
 *	Return -1 if the congruence is not possible.
 */
int mod(int x, int m){return x % m + (x < 0) ? m : 0;}

int solve_mod(int a, int b, int m){
	if(m < 0) return solve_mod(a, b, -m);
	if(a < 0 || a >= m || b < 0 || b >= m)
		return solve_mod(mod(a, m), mod(b, m), m);
	bezout t = find_bezout(a, m);
	int d = t.first * a + t.second * m;
	if(b % d) return -1;
	else return mod(t.first * (b / d), m);
}

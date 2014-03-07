typedef long long ll;
ll lcm(int x, int y){
	if(x && y) return abs(x) / gcd(x,y) * ll(y);
}

//If you need it for long values, remember to change abs to labs
int gcd(int x, int y){return y ? gcd(y , x % y) : abs(x);}

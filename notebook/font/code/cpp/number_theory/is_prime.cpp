bool is_prime(int n){
	if(n < 0) return is_prime(-n);
	if(n < 5 || n % 2 == 0 || n % 3 == 0) return (n == 2 || n == 3);
	int maxP = sqrt(n) + 2;
	for(int p = 5; p < maxP; p += 6)
		if(n % p == 0 || n % (p+2) == 0 ) return false;
	return true;
}

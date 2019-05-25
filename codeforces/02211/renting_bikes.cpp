#include<iostream>
#include<algorithm>

#define min(a,b) (a) < (b) ? (a) : (b)
#define max(a,b) (a) > (b) ? (a) : (b)

using namespace std;

int money[100010], bike[100010];
long long t = 0ll, k, a;
int n,m;

bool f(int p){
	long long personal = 0ll, comm = a;
	for(int i= n - p, j = 0; i < n; i++, j++){
		if(money[i] + comm < bike[j])
			return false;
		else{
			personal += min(money[i], bike[j]);
			comm -= max(0ll, bike[j] - money[i]); 
		}
	}
	t = max(0ll, personal - comm);
	return true;
}

int main(){
	
	cin >> n >> m >> a;
	
	for(int i=0;i<n;i++)
		cin >> money[i];
	
	for(int i=0;i<m;i++)
		cin >> bike[i];

	sort(money, money + n);
	sort(bike, bike + m);

	int ll = 0, rr = min(m,n), mm;
	while( ll < rr ){
		mm  = (ll +  rr + 1) >> 1;
		if( f(mm) )
			ll = mm;
		else 
			rr = mm - 1; 
	}
	cout << ll << " " << t << endl;
	return 0;
}

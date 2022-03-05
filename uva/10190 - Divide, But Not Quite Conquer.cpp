#include<iostream>
#include<vector>


using namespace std;

vector<int> v;

bool f(int n,int m){
//	cout << "f(" << n << ", " <<m << ")" << endl;
	v.push_back(n);
	if(n==1)
		return true;
	if(n%m)
		return false;
	f(n/m,m);
}
template<class T>
ostream& operator<<(ostream& o,vector<T> v){
	for(int i=0; i<v.size(); i++)
		o << v[i] << (i<v.size()-1?" ":"");
	return o;
}

int main(){
	int m,n;
	while(cin>>n>>m){
		v.clear();
		if((n>=2 && m>=2 && m<=n) && f(n,m))
			cout << v << endl;
		else cout << "Boring!" << endl;
	}
}

#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

#define all(c) (c).begin(),(c).end()
#define sz(c) (c).size()
bool check(const string &s, const string &p1, const string &p2){
	int i1,i2;
	i1 = s.find(p1);
	if(i1 != -1){
		i2 = s.find(p2, i1 + p1.size());
		if(i2 != -1)
			return true;
		return false;
	}
	else
		return false;
}
	
int main(){
	
	//freopen("a.in" , "r" , stdin);
	string fwd,bwd,p1,p2;
	int i1,i2;
	cin>>fwd>>p1>>p2;
	bwd = fwd;
	reverse(all(bwd));
	bool f = check(fwd,p1,p2) ,b = check(bwd,p1,p2);
	if(f && b)
		cout << "both";
	if(f && !b)
		cout << "forward";
	if(!f && b)
		cout << "backward";
	if(!f && !b)
		cout << "fantasy";
	cout << endl;
	return 0;
}



#include<cstdio>
#include<algorithm>
#include<string>
#include<iostream>


#define all(c) (c).begin(),(c).end()

using namespace std;

int main(){
	int x;
	cin>>x;
	string s;
	while(x-- && cin>>s){
		sort(all(s));
		do
			cout << s << endl;
		while(next_permutation(all(s)));
		cout << endl;
	} 
	return 0;
}

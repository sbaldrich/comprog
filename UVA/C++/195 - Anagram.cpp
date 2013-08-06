#include<string>
#include<algorithm>
#include<iostream>
#include<cctype>


using namespace std;

bool _comp(const char &a,const char &b){
	int d = tolower(a) - tolower(b);
	return d?d<0:a<b;
}

int main(){
	int x;
	cin>>x;
	string s;
	while(x--){
		cin >> s;
		sort(s.begin(),s.end(),_comp);
		do
			cout << s << endl;
		while(next_permutation(s.begin(),s.end(),_comp));
	}
	return 0;
}

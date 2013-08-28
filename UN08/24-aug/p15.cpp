#include<iostream>

using namespace std;

int droot(long long &n){
	long long root = 0;
	while(n >= 10){
		root += (n%10);
		n/=10;
	}
	root+=n;
	if(root >= 10)
		return droot(root);
	else return root;
}

int main(){
	string str;
	while(cin>>str){
		if(str[0] == '0')
			break;
		long long s = 0;
		for(int i=0;i<str.size();i++)
			s+=str[i]-'0';
		cout << droot(s) << endl;
	}
	return 0;
}

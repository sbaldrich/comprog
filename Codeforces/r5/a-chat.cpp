#include<string>
#include<iostream>

using namespace std;

int main(){
	
	freopen("a.in" , "r", stdin);
	
	int p = 0, ans = 0;
	string line;
		while(getline(cin,line) && !line.empty()){
		char &r = line[0];
		if(r == '+')
			p++;
		else if(r == '-')
			p--;
		else
			ans += line.substr(line.find(':') + 1).size() * p;
	}
	cout << ans << endl;
	return 0;
}


#include<iostream>
#include<map>
#include<sstream>

using namespace std;

string s[] = {"063", "010", "093", "079", "106","103", "119", "011", "127", "107"};

map<string,int> M;

int toi(string s){
	int a = 0, m = 1;
	string aux;
	for(int i=s.size()-1;i>=0;i-=3){
		aux = s.substr(i-2,3);
		a += M[aux] * m, m*=10;
	}
	return a;
}

string tos(int n){
	string ret = "";
	while(n>0){
		ret = s[n%10] + ret;
		n/=10;
	}
	return ret;
}

int main(){

	//freopen("seven.in" , "r", stdin);

	M[s[0]] = 0;M[s[1]] = 1;
	M[s[2]] = 2;M[s[3]] = 3;
	M[s[4]] = 4;M[s[5]] = 5;
	M[s[6]] = 6;M[s[7]] = 7;
	M[s[8]] = 8;M[s[9]] = 9;

	string line;
	while(cin>>line && line!="BYE"){
		string ans = line;
		line[line.find("+")] = line[line.find("=")] = ' ';
		stringstream ss(line);
		string n1, n2;
		ss>>n1 >> n2;
		int c = toi(n1) + toi(n2);
		cout << ans << tos(c) << endl;
	}
	return 0;
}

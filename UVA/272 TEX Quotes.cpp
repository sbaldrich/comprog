#include<iostream>
#include<string>

using namespace std;

int main(){
	freopen("272.in" , "r", stdin);	
	string line;
	bool flag = true;
	while(getline(cin,line)){
		for(int i=0;i<line.size();i++){
			if(line[i] == '"'){
				cout << (flag?"``":"''");
				flag = !flag;
			}else{
				cout << line[i];
			}
		}
		cout << endl;
	}
	return 0;
}

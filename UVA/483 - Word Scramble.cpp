#include<algorithm>
#include<iostream>
#include<sstream>
#include<string>

using namespace std;

#define all(c) c.begin(),c.end()

int main(){
	string line,word;
	
	while(getline(cin,line)){
		stringstream ss(line);
		int pos = 0;
		for(;pos < line.size();pos++){
			if(line[pos] != ' '){
				ss>>word;
				reverse(all(word));
				cout << word;
				pos+=(word.size()-1);
			}else cout << line[pos];
		}
		cout << endl;
	}
	return 0;
}

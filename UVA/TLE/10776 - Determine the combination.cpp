#include<algorithm>
#include<string>
#include<iostream>
#include<set>

using namespace std;

#define all(c) (c).begin(),(c).end()
#define tr(c,it) for(typeof((c).begin()) it=(c).begin(); it!=(c).end(); it++)

string str;
set<string>ans;

void f(string s, int idx, int c_left){
	//printf("f(%s,%d,%d)\n" , s.c_str(), idx, c_left);
	if(!c_left){
		ans.insert(s);
		return;
	}
	
	for(int i=idx;i<str.size();i++)
		f(s+str[i],i+1,c_left-1);
}

int main(){
	int r;
	char temp[40];
	while(scanf("%s %d", &temp, &r) > 1 ){
		ans.clear();
		str = string(temp);
		sort(all(str));
		//printf("%s" , str.c_str());
		f("",0,r);
		tr(ans,it)
			printf("%s\n", (*it).c_str());
	}
	return 0;
}

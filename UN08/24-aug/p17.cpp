#include<iostream>
#include<string>
#include<algorithm>
#include<set>
#include<map>
#include<cstdio>

using namespace std;

map<string, multiset<string> > M;

int main(){
	freopen("p17.in",  "r", stdin);
	//freopen("p17.out",  "w", stdout);

	int n;
	char buf[20];
	string s,t;
	scanf("%d", &n);
	bool line = false;
	while(n--){
		scanf("%s",buf);
		s = string(buf);
		t = s;
		if(s.size()>1)
			sort(s.begin()+1,s.end()-1);
		if(M.find(s) == M.end())
			M[s] = multiset<string>();
		M[s].insert(t);
	}
	scanf("%d", &n);
	while(n--){
		//printf("%d\n" , n);
		//if(line)
		//	printf("\n");
		int ans = 0;
		string l, r;
		scanf("%s", buf);
		s = string(buf);
		//printf("processing %s\n" , s.c_str()); 
		if(s.size() > 1)
			sort(s.begin()+1,s.end()-1);
		if(M.find(s) != M.end()){
			multiset<string> :: iterator it = M[s].begin();
			multiset<string> :: reverse_iterator it2 = M[s].rbegin();
			printf("%d %s %s", M[s].size(), (*it).c_str(), (*it2).c_str());
		}
		else printf("0");
		printf("\n");
		line = true;
	}
	return 0;	
}

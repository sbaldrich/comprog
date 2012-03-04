#include<algorithm>
#include<iostream>
#include<vector>
#include<map>
#include<set>
#include<queue>
#include<sstream>
#include<cstring>
#include<cstdlib>
#include<cstdio>
#include<string>
#include<cmath>

using namespace std;

#define oo                 INT_MAX
#define fi(n,i)             for(int (i)=0;(i)<(n); (i)++)
#define fs                  first
#define sc                  second
#define all(c)              (c).begin(),(c).end()
#define halt                system("pause > nul")

int main()
{
    //freopen("uva483.in"  , "r" , stdin);
//    freopen("uva483.out" , "w" , stdout);


   	string line;
   	while( getline(cin, line)) {
   		string word = "";
   		line += " ";
   		fi(line.size(),i) {
   			if (line[i] == ' ') {
   				if (word.size() > 0) {
   					reverse(word.begin(), word.end());
   					printf("%s", word.c_str());
   				}
   				if (i != line.size()-1) printf("%c", line[i]);
   				word = "";
   			}
   			else {
   				word += line[i];
   			}
  		}
   		printf("\n");
   	}
   	return 0;
  }


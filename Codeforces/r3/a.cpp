#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

#define max(a,b) (a) > (b) ? (a) : (b)
#define abs(x) (x) < 0 ? -1*(x) : (x)

int main()
{

	string s,e;
	int s1,s2,e1,e2;	
	cin>>s>>e;
	s1 = s[0] - 'a' + 1;
	e1 = e[0] - 'a' + 1;
	s2 = s[1] - '0';
	e2 = e[1] - '0';
	printf("%d\n", max(abs(s1 - e1) , abs(s2 - e2)));
	while(s2 < e2 && s1 < e1 )printf("RU\n"),++s1, ++s2;
	while(s2 < e2 && s1 > e1 )printf("LU\n"),--s1, ++s2;
	while(s2 > e2 && s1 < e1 )printf("RD\n"),++s1, --s2;
	while(s2 > e2 && s1 > e1 )printf("LD\n"),--s1, --s2;
	while(s1 < e1)printf("R\n") , s1++;
	while(s1 > e1)printf("L\n") , s1--;
	while(s2 > e2)printf("D\n") , s2--;
	while(s2 < e2)printf("U\n") , s2++;
	
	return 0;
}


#include<iostream>
#include<string>
#include<map>
#include<algorithm>


/*
 * Created on: Oct 30, 2011
 * Author: sbaldrich
 * Problem : B - Led Codes
 * Source: South America 2000 Regional Contest
 */


#define all(c) (c).begin(),(c).end()

using namespace std;

map<string,char> relation;
string led[] = {"123457" , "1234567" , "456" , "0158" , "12456" , "1249" , "12569" , "13457",
				"37" , "3567" , "13459" , "156" , "12357" , "3579" , "123567" , "1458",
				"12347" ,"123459" , "12467" , "278" , "13567" , "1379" , "013579" , "09",
				"1347" , "23456"};

const string num = "0123456789";

bool isnum(char &c)
{
	if(num.find(c)!=string::npos)
		return true;
	return false;
}

int main()
{
	int N;
	string line,X;
	for(int i = 'A'; i<='Z';i++)
		relation[led[i-'A']] = (char)i;
	cin>>N;
	getline(cin,line);
	for(int c=0;c<N;c++)
	{

		getline(cin,line);
		cout << "Phrase "<<c+1<<": ";
		int sz = line.size();
		X.clear();
		for(int i=0;i<sz;i++)
		{
			if(!isnum(line[i]))
			{
				cout << line[i];
			}
			else if(line[i] =='0' && X.size()==0)
				cout <<' ';
			else
			{
				X+=line[i];
				sort(all(X));
				if(relation.count(X))
					cout << relation[X],X.clear();
			}
		}
		cout << endl;
	}
	return 0;
}






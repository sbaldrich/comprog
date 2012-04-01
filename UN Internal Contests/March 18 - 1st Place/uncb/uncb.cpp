#include <string>
#include <list>
#include <fstream>
#include <iostream>
#include <algorithm>
#include <set>
#include <stdio.h>

using namespace std;

#ifndef ONLINE_JUDGE
ifstream fin("245.in");
ofstream fout("out.txt");
#else
#define fin std::cin
#define fout std::cout
#endif

list<string> dict;
set<string> words;
enum eLexType {
	Word, Number, Other, End
};
eLexType getlex(string& s);
string in("");
unsigned long i = 0;

list<string>::iterator Exists(const string& s);
bool IsAlpha(char c);
bool IsDigit(char c);
void DeCompress();

int main() {
	DeCompress();
	return 0;
}

void DeCompress() {
	eLexType type;
	string s;

	getline(fin, in, '\n');
	i = 0;

	list<string>::iterator iter;
	while ((type = getlex(s)) != End) {
		switch (type) {
		case Word: {
			iter = Exists(s);
			if (iter == dict.end()) {
				dict.push_back(s);
				words.insert(s);
			} else
				dict.splice(dict.end(), dict, iter);
			fout << s;
			break;
		}
		case Number: {
			int nIndex;
			sscanf(s.c_str(), "%d", &nIndex);
			for (iter = dict.end(); nIndex > 0; nIndex--)
				iter--;
			fout << *iter;
			dict.splice(dict.end(), dict, iter);
			break;
		}
		case Other:
			fout << s;
			break;
		}
	}
}
eLexType getlex(string& s) {

	if (i >= in.length()) {
		if (fin.eof())
			return End;
		getline(fin, in, '\n');
		i = 0;

		s = "\n";
		return Other;
	}

	if (in == "0")
		return End;
	if (IsAlpha(in[i])) {
		s = in[i];
		for (i++; i < in.length() && IsAlpha(in[i]); i++)
			s += in[i];
		return Word;
	}

	if (IsDigit(in[i])) {
		s = in[i];
		for (i++; i < in.length() && IsDigit(in[i]); i++)
			s += in[i];
		return Number;
	}

	s = in[i++];
	return Other;
}
list<string>::iterator Exists(const string& s) {
	if (words.find(s) != words.end()) {
		for (list<string>::iterator iter = dict.begin(); iter != dict.end();
				iter++)
			if (*iter == s)
				return iter;
	} else
		return dict.end();
}

bool IsAlpha(char c) {
	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
}
bool IsDigit(char c) {
	return (c >= '0' && c <= '9');
}

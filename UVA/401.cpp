#include<iostream>
#include<string>
#include<map>
#include<algorithm>

using namespace std;

string verdicts[] = {"not a palindrome." , "a regular palindrome." , "a mirrored string." , "a mirrored palindrome."};
map <char,char> mirror;

void m_ins(char a,char b)
{
	mirror[a] = b;
}

bool isPal(string &s)
{
	string r = s;
	reverse(r.begin(), r.end());
	if(s.compare(r) == 0)
		return true;
	return false;
}

bool isMirror(string &s)
{
	string r = s;
	int n = r.size();
	for(int i=0;i<n;i++)
		if(mirror.count(r[i]))
			r[i] = mirror[i];
		else return false;
	if(s.compare(r) == 0)
		return true;
	return false;
}



int main()
{
	freopen("401.in" , "r" , stdin);

	m_ins('A' , 'A');	m_ins('E' , '3');
	m_ins('H' , 'H');	m_ins('I' , 'I');
	m_ins('J' , 'L');	m_ins('L' , 'J');
	m_ins('M' , 'M');	m_ins('0' , 'O');
	m_ins('O' , 'O');	m_ins('S' , '2');
	m_ins('T' , 'T');	m_ins('U' , 'U');
	m_ins('V' , 'V');	m_ins('W' , 'W');
	m_ins('X' , 'X');	m_ins('Y' , 'Y');
	m_ins('Z' , '5');	m_ins('1' , '1');
	m_ins('2' , 'S');	m_ins('3' , 'E');
	m_ins('5' , 'Z');	m_ins('8' , '8');

	string in;
	int v = 0;
	while(cin>> in)
	{
		bool pal = isPal(in) , mir=isMirror(in);
		if(pal && mir)
			v = 3;
		else if(pal)
			v = 1;
		else if(mir)
			v=2;
		cout << in << " is "<< verdicts[v]<<endl;

	}

	return 0;
}




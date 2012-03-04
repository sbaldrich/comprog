/*
 * Created on: 07/11/2011
 * Author: sbaldrich
 * Problem: The Next Permutation
 * Source: Greater New York 2009
 */

#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main(){
	//freopen("E.in" , "r" ,stdin);
	int P,c;
	string s,initial;
	cin>>P;
	for(int z=0;z<P;z++)
	{
		cin>>c>>s;
		initial = s;
		sort(initial.begin(), initial.end());
		next_permutation(s.begin(),s.end());
		cout << c << " "<<(s.compare(initial)==0?"BIGGEST":s)<<endl;
	}
	return 0;
}





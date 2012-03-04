/*
 * Created on: 10/11/2011
 * Author: sbaldrich
 * Problem I - Theta Puzzle
 * Source: Greater New York 2009
 */

#include<string>
#include<queue>
#include<set>
#include<utility>
#include<iostream>
#include<sstream>


#define mp make_pair
#define fs first
#define sc second

using namespace std;

char c;
void swap(char &a , char &b)
{
	c = a;
	a = b;
	b = c;
}

const string end = "ABCDEF ";

/*  Direction to which each of the 7 positions can go.
 *
 *	-1 means you would break the puzzle by attepting to move to that
 *	position and mom would kick your butt.
 */
int edges[7][3]= { {5,1,-1} , {0,6,2} , {1,3,-1} , {2,4,-1}, {3,5,6} , {4,0,-1}, {1,4,-1} };


typedef pair< string , pair<int,string > > state;

set<string> visit;
queue<state> Q;

string bfs(string &start)
{
	visit.clear();
	Q = queue<state>();
	visit.insert(start);
	Q.push(mp(start , mp(6,"")));
	state x;
	string aux;
	while(!Q.empty())
	{
		x = Q.front();
		Q.pop();
		if(x.fs == end)
		{
			ostringstream iss;
			iss<<x.sc.sc.size()<<" "<<x.sc.sc;
			return iss.str();
		}
		int space = x.sc.fs;
		for(int j=0;j<3;j++)
		{
			aux = x.fs;
			if(edges[space][j] > -1)
			{
				swap(aux[space],aux[edges[space][j]]);
				if(!visit.count(aux))
					Q.push(mp(aux,mp(edges[space][j],(x.sc.sc+x.fs[edges[space][j]])))),
					visit.insert(aux);

			}
		}
	}
	return "NO SOLUTION";
}



int main()
{

	//freopen("I.in" ,"r" , stdin);
	int P , c;
	cin>>P;
	string start;
	for(int i=0;i<P;i++)
	{
		cin>>c>>start;
		start+=" ";
		cout << c << " " << bfs(start)<<endl;
	}
	return 0;
}


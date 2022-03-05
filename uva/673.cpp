#include<stack>
#include<iostream>
#include<string>
#include<cstdio>

using namespace std;

int main() {
	//freopen("673.in", "r", stdin);

	string line;
	int c;
	getline(cin, line);
	sscanf(line.c_str(), "%d", &c);
	while (c--) {
		getline(cin, line);
		bool ok = true;
		stack<char> s;
		if (line.length() > 0) {
			for (int i = 0; i < (int) line.length() && ok; i++) {
				if (line[i] == '(' || line[i] == '[') {
					s.push(line[i]);
				} else {
					if (line[i] == ')') {
						if (!s.empty() && s.top() == '(')
							s.pop();
						else
							ok = false;
					} else {
						if (!s.empty() && s.top() == '[' )
							s.pop();
						else
							ok = false;
					}
				}

			}
		}
		if (ok && s.size() == 0)
			cout << "Yes";
		else
			cout << "No";
		cout << endl;


	}
	return 0;

}


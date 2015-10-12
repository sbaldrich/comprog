#include <bits/stdc++.h>

using namespace std;

class LiveConcert {
public:
	int maxHappiness(vector <int> h, vector <string> s) {
		map<string,int> song;
		int n = s.size();
		for(int i = 0; i < n; i++){
			if(song.find(s[i]) != song.end())
				song[s[i]] = h[i] > song[s[i]] ? h[i] : song[s[i]];
			else song[s[i]] = h[i];
		}
		int ans = 0;
		for(map<string,int> :: iterator it = song.begin(); it != song.end(); it++)
			ans += it -> second;
		return ans;
	}
};

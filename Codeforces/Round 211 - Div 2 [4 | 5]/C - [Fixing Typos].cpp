#include<iostream>
#include<string>

using namespace std;

int main(){
	string s, ans;
	cin >> s;
	if(s.size() <= 2)
		cout << s;
	else{
		ans = s.substr(0,2);
		for(int i=2,k=1;i<s.size();i++){
			if((s[i] == ans[k] && s[i] == ans[k-1]) || (ans.size() > 2 && ans[k-2] == ans[k-1] && ans[k] == s[i] ))
				continue;
			else{
				ans += s[i];
				k++;
			}
				
		}
		cout << ans << endl;
	}
	return 0;
}

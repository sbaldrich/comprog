#include<iostream>

using namespace std;

int main(){
	int l,h,c,ans=0,x; //low high contests
	cin>>c;
	for(int i=0;i<c;i++){
		cin>>x;
		if(i == 0){
			l = h =  x;
			continue;
		}
		if(x < l){
			ans++;
			l = x;
		}
		else if(x>h){
			ans++;
			h = x;
		}
	}
	cout << ans << endl;
	return 0;
}

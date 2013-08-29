#include<iostream>
#include<algorithm>

using namespace std;

int main(){
	
//	freopen("a.in" , "r" , stdin);
	int a[4];
	for(int i=0;i<4;i++)
		cin>> a[i];
	bool seg = false;
	sort(a,a+4);
	for(int i=0;i<4;i++)
		for(int j=i+1;j<4;j++)
			for(int k=j+1;k<4;k++){
				if(a[i] + a[j] > a[k]){
					cout << "TRIANGLE" << endl;
					return 0;
				}
				else if(a[i] + a[j] == a[k])
					seg = true;
			}
	cout << (seg?"SEGMENT":"IMPOSSIBLE") << endl;
	return 0;
}



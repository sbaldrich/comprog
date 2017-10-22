#include<bits/stdc++.h>

using namespace std;

int a[5], n;
int main(){
    cin >> n;
    for(int i = 0, x; i < n; i++) cin >>x, a[x - 1]++;
    cout << (max_element(a, a + 5) - a) + 1 << endl;
    return 0;
}

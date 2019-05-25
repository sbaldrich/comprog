#include<bits/stdc++.h>

using namespace std;

inline bool colinear(int a, int b, int m, int n, int x, int y){
    return (x-m) * (n-b) == (m-a) * (y-n);
}
int main(){
    int n, x0, y0; cin >> n >> x0 >> y0;
    int ans = 0;
    vector<int> px(n), py(n);
    vector<bool> dead(n,false);
    for(int i=0; i<n; i++)
        cin >> px[i] >> py[i];
    if(n < 2){
        cout << n << endl;
        return 0;
    }
    for(int i=0; i<n; i++){
        if(!dead[i]){
            dead[i] = true;
            for(int j=0; j<n; j++)
                if(!dead[j] && colinear(px[i], py[i], x0, y0, px[j], py[j]))
                    dead[j] = true;             
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}
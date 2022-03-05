/*
ID:santiag4
PROG: beads
LANG: C++
*/

#include<iostream>

using namespace std;

main(){
       freopen("beads.in","r",stdin);
       freopen("beads.out","w",stdout);
       int size;
       while(cin >> size){
                    string original,duplicate ;
                    cin >> original;
                    duplicate=original+original;
                    int ans=0,prev = 0 ,curr = 0, w=0;
                    char color;
                    for(int i = 0; (i<size*2 && (prev + curr) < size) ; i++){
                            if(duplicate[i] == 'w'){
                                            w++;
                                            curr++;
                                            }
                            else if(duplicate[i] == color){
                                            w=0;
                                            curr++;
                                            }
                            else {
                                            color = duplicate[i];
                                            if(prev + curr >ans)ans = prev + curr;
                                            prev = curr-w;
                                            curr = w+1;
                                            w=0;
                                                      
                                 }               
                            }
                   if(prev + curr >ans)ans = prev + curr;
                   if(ans<=size)cout << ans <<endl;
                   else cout << size << endl;
                            
                 }
       }

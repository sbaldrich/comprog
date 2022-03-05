/*
ID: santiag4
PROG: ride
LANG: C++
*/
#include<iostream>

using namespace std;
int process(string str){
    int sz=str.size();
    int ans=1;
    for(int i=0;i<sz;i++){
            //cout<<str[i]-'A'+1<<" ";
            ans*=(int)(str[i]-'A'+1);
            }
    //cout<<endl;
    //cout<<ans;
    return ans%47;
    }
main(){
       freopen("ride.in","r",stdin);
       freopen("ride.out","w",stdout);
       
       string group,comet;
       while(cin>>group){
                         cin>>comet;
      //                   cout<<group<<" "<<comet<<endl;
                         if(process(group)==process(comet))cout<<"GO";
                         else cout<<"STAY";
                         cout<<endl;
                         }
       return 0;                  
       }

/*
ID:santiag4
PROG: friday
LANG: C++
*/

#include<iostream>

using namespace std;

int day(int n){
    return (n+1)%7;
    }
bool isLeap(int year){
     if(year==1900)return false;
     if(year%100!=0&&year%4==0)return true;
     if(year%400==0)return true;
     return false;
     }
main(){
       freopen("friday.in","r",stdin);
       freopen("friday.out","w",stdout);
       
       int months[12]={31,28,31,30,31,30,31,31,30,31,30,31};
       int days[7];
       //memset(days,0,sizeof(days));       
       for(int i=0;i<7;i++)days[i]=0;
       int year=1900;
       int N;
       int n=13;
       cin>>N;
       for(int i=0;i<N;i++){
               if(isLeap(year))months[1]=29;
               for(int k=0;k<12;k++){
                                 days[day(n)]++;
                                 n+=months[k];
                                 //for(int i=0;i<7;i++)cout<<days[i]<<" ";
                                 //cout<<endl;
                                 }
               months[1]=28;                  
               year++;
               }
       for(int i=0;i<6;i++)cout<<days[i]<<" ";
       cout<<days[6]<<endl;
       
       }
       

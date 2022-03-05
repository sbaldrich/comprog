/*
ID:santiag4
PROG: gift1
LANG: C++
*/

#include<iostream>

using namespace std;

struct person{
       string name;
       int initial;
       int final;
       };
       
person all[10];    

int getId(string n){
    int i=0;
    while(all[i++].name!=n);
    return i-1;
    }

main(){
       freopen("gift1.in","r",stdin);
       freopen("gift1.out","w",stdout);
       
       int NP;
       cin>>NP;
       
       for(int i=0;i<NP;i++){
               cin>>all[i].name;
               all[i].initial=all[i].final=0;
               }
       string giver;
       while(cin>>giver){
                         int init,rec,id=getId(giver); // inicial, # gente que recibe,id que se procesa
                         cin>>init>>rec;
                         all[id].initial=init;
                         all[id].final+=init;
                         for(int i=0;i<rec;i++){
                                 string turn;
                                 int idTurn;
                                 cin>>turn;
                                 idTurn=getId(turn);
                                 all[idTurn].final+=init/rec;
                                 }
                         if(rec)all[id].final-=(init/rec)*rec;        
                         }
       for(int i=0;i<NP;i++){
               cout<<all[i].name<<" "<<(all[i].final-all[i].initial)<<endl;
               }
       }

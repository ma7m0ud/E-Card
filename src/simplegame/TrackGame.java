/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplegame;
public class TrackGame{
private int level=1, score=0,score1=0, cards=0,track=0;
boolean emp=false;
int roundforscore[]={0,0,0,0,0,0,0,0,0,0,0,0};
String player1=null,player2=null;
public void settrack(int track){
this.track=track;
}
public int gettrack(){
return track;
}
public void setlevel(int lev){
level=lev;
}public void setplayer1score(int sco,int roundnum){
   
score+=sco;

}public void setplayer2score(int sco,int roundnum){
   
score1+=sco;
}

public boolean levelemp(){
if(level==1||level==2||level==3||level==7||level==8||level==9){
emp=true;
}
if(level==4||level==5||level==6||level==10||level==11||level==12){
emp=false;
}
return emp;}
public void cardcoun(int car){
cards=car;
}
public void initcards(){
cards=0;
}
public int getcardcount(){

return cards;}
public int getlevel(){
return level;
}
public int getplayer1score(){
return score;
}public int getplayer2score(){
return score1;
}

}
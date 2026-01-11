 #include <stdio.h>
 int R,C,w,s,N=0;
 int SumOfWolf=0, SumOfSheep=0;
 char Arr[251][251]={'#',};
 int Vis[251][251]={0,};
 void DFS(int x,int y){
     Vis[x][y]=1;
     if(Arr[x][y]=='v') w++;
     else if(Arr[x][y]=='o') s++;
 
     if(Arr[x+1][y]!='#' && Vis[x+1][y]==0 && x+1<R) DFS(x+1,y);
     if(Arr[x][y+1]!='#' && Vis[x][y+1]==0 && y+1<C) DFS(x,y+1);
     if(Arr[x-1][y]!='#' && Vis[x-1][y]==0 && x>0) DFS(x-1,y);
     if(Arr[x][y-1]!='#' && Vis[x][y-1]==0 && y>0) DFS(x,y-1);
 }
 int main(void){
         scanf("%d %d", &R, &C);
         for(int i=0;i<R;i++) scanf("%s", Arr[i]);
         for(int i=0;i<R;i++){
                 for(int j=0;j<C;j++){
                         if(Arr[i][j]!='#' && Vis[i][j]==0){
                                 w=s=0;
                                 DFS(i,j);
                                 if(w>=s) SumOfWolf+=w;
                                 else if(w<s) SumOfSheep+=s;
                         } 
                 }
 
         }
         printf("%d %d", SumOfSheep, SumOfWolf);
 } 
 

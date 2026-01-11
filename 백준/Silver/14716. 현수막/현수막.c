#include <stdio.h>
int M,N,Cnt=0;
int Arr[251][251]={}, Vis[251][251]={0,};
void DFS(int x, int y){
        Vis[x][y]=1;
        if(Arr[x+1][y]==1 && Vis[x+1][y]==0 && x+1<M) DFS(x+1,y);
        if(Arr[x][y+1]==1 && Vis[x][y+1]==0 && y+1<N) DFS(x,y+1);
        if(Arr[x-1][y]==1 && Vis[x-1][y]==0 && x>0) DFS(x-1,y);
        if(Arr[x][y-1]==1 && Vis[x][y-1]==0 && y>0) DFS(x,y-1);

        if(Arr[x-1][y-1]==1 && Vis[x-1][y-1]==0 && x>0 && y>0) DFS(x-1,y-1);
        if(Arr[x-1][y+1]==1 && Vis[x-1][y+1]==0 && x>0 && y+1<N) DFS(x-1,y+1);
        if(Arr[x+1][y-1]==1 && Vis[x+1][y-1]==0 && x+1<M && y>0) DFS(x+1,y-1);
        if(Arr[x+1][y+1]==1 && Vis[x+1][y+1]==0 && x+1<M && y+1<N) DFS(x+1,y+1);
}
int main(void){
        scanf("%d %d", &M,&N);
        for(int i=0;i<M;i++) for(int j=0;j<N;j++) scanf("%d", &Arr[i][j]);
        for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                        if(Arr[i][j]==1 && Vis[i][j]==0){
                                Cnt++;
                                DFS(i,j);
                       }              
                }
         }
         printf("%d", Cnt);
}

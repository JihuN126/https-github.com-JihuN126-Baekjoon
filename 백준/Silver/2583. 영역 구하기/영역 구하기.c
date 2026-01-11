#include <stdio.h>
#include <stdlib.h>

int Arr[101][101]={0,};
int Vis[101][101]={0,};
int G[1000]={0,};
int CNT=-1;
int N,M,K;

int Sort(const void* x, const void* y){
		int X=*(int*)x;
		int Y=*(int*)y;
		if(X>Y) return 1;
		else return -1;
}
void BFS(int A,int B){
		Vis[A][B]=1;
		G[CNT]++;
		if(Arr[A][B+1]==0 && !Vis[A][B+1] && B+1!=M) BFS(A,B+1);
		if(Arr[A+1][B]==0 && !Vis[A+1][B] && A+1!=N) BFS(A+1,B);
		if(Arr[A][B-1]==0 && !Vis[A][B-1] && B>0) BFS(A,B-1);
		if(Arr[A-1][B]==0 && !Vis[A-1][B] && A>0) BFS(A-1,B);
		return;
}

int main(void){
		scanf("%d %d %d",&N,&M,&K);
		
		for(int i=0;i<K;i++){
				int x1,y1,x2,y2;
				scanf("%d %d %d %d", &x1,&y1,&x2,&y2);
				for(int j=N-y2;j<=N-y1-1;j++){
						for(int k=x1;k<x2;k++)	
								Arr[j][k]=1;
					}
		}
		
		for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
						if(Arr[i][j]==0 && !Vis[i][j]){
								CNT++;
								BFS(i,j);
						}
				}
		}
		qsort(G,CNT+1,sizeof(int),Sort);
		printf("%d\n" , CNT+1);
		for(int i=0;i<=CNT;i++) printf("%d ", G[i]);
}



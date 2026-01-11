#include <stdio.h>
int G[101][101];
int Vis[101][101]={0,};
int P[101][101]={0,};
int N;

void DFS(int K,int A){
		for(int i=0;i<N;i++){
				if(G[K][i]==1 && Vis[A][i]==0){
					Vis[A][i]=1;
					P[A][i]=1;
					DFS(i,A);
				}
		}
}



int main(void){
		scanf("%d", &N);
		for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
						scanf("%d", &G[i][j]);
				}
		}
		for(int i=0;i<N;i++){
				DFS(i,i);
				for(int j=0;j<N;j++) printf("%d ",P[i][j]);
				printf("\n");
		}
}


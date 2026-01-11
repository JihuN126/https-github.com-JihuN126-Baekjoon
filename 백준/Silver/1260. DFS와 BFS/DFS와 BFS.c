#include <stdio.h>

int Queue[1010];
int front=-1;
int rear=-1;

int Empty(){
	if(front==rear){
		return 1;
	}
	return 0;
}

void Push(int N){
	Queue[++rear]=N;
}

int Ffront(){
	return Queue[front+1];
}
int Matrix[1010][1010]={0,};
int DFSVisited[1010]={0,};
int BFSVisited[1010]={0,};
int N,M,V;

void DFS(int V){
	DFSVisited[V]=1;
	for(int i=1; i<=N; i++){
		if(Matrix[V][i]&&!DFSVisited[i]){
			printf("%d ",i);
			DFS(i);
		}
	} 
}

void BFS(int V){
	BFSVisited[V]=1; 
	Push(V);
	while(!Empty()){
		int k=Ffront();
		++front;
		for(int i=1; i<=N; i++){
			if(Matrix[k][i]&&!BFSVisited[i]){
				BFSVisited[i]=1;
				Push(i);
				printf("%d ",i);
			}
		}
	}
}

int main(void){
	int A,B; 
	scanf("%d %d %d",&N,&M,&V);
	
	for(int i=0; i<M; i++){
		scanf("%d %d",&A,&B);
		Matrix[A][B]=1;
		Matrix[B][A]=1;
	}
	printf("%d ",V);
	DFS(V);
	printf("\n%d ",V);
	BFS(V);
	return 0;
}

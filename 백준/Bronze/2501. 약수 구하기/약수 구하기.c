#include<stdio.h>
int main(void){
        int n,k,count=0;
        scanf("%d %d", &n, &k);
        int A[10001]={0};
        for(int i=1;i<n+1;i++){
                if(n%i==0){
                        A[count]=i;
                        count++;
                }
        }
        if(A[k-1]==0) printf("0");
        else    printf("%d", A[k-1]);
        return 0;
}

#include <stdio.h>
#include <string.h>
int main(void){
        char A[100];
        scanf("%s", A);
        for(int i=0;i<strlen(A);i++){
                if(i!=0 && i%10==0)
                        printf("\n");
                printf("%c",A[i]);
        }
        return 0;
}

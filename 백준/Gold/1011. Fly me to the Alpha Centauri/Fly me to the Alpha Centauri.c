#include <stdio.h>
int A(int s){
        if(s<3){
                return s;
        }
        long long n,sum=2,a=2;
        for(n=1;sum<s;n++){
                if(n%2==1 && n!=1) a++;
                sum+=a;
        }
        return n+1;
}
int main(void){
        long long x,y,n,k,l;
        scanf("%lld", &k);
        for(long long i=0;i<k;i++){
                scanf("%lld %lld", &x, &y);
                l=y-x;
                printf("%d\n", A(l));
        }
        return 0;
}

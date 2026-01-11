#include <stdio.h>
#include <stdlib.h>
 
 int compare(const void* a, const void* b) {
     return *(int*)a > * (int*)b ? 1 : *(int*)a < *(int*)b ? -1 : 0;
 }
 int binsearch(int arr[], int n, int key) {
     int low = 0, high = n - 1, mid;
     while (low <= high) {
         mid = (low + high) / 2;
         if (arr[mid] == key)
             return 1;
         else if (arr[mid] > key)
             high = mid - 1;
         else if (arr[mid] < key)
             low = mid + 1;
     }
     return 0;
 }
 
 int main(void){
     int N,M,D;
     scanf("%d", &N);
     int* arr = (int*)malloc(sizeof(int) * N);
     for (int i=0;i<N;i++)
         scanf("%d", &arr[i]);
     qsort(arr, N, sizeof(int), compare);
     scanf("%d", &M);
     int* ans = (int*)malloc(sizeof(int) * M);
     for (int i=0;i<M;i++) {
         scanf("%d", &D);
         ans[i] = binsearch(arr, N, D);
     }
     for (int i=0;i<M;i++)
         printf("%d\n", ans[i]);
     free(arr);
     free(ans);
     return 0;
}

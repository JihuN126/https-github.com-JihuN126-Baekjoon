import java.util.*;
class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] checked = new boolean[n+1][n+1];
        for(int[] temp : results) {
            checked[temp[0]][temp[1]] = true;
        }
        
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                if(i==k) continue;
                for(int j=1;j<=n;j++) {
                    if(checked[i][k] && checked[k][j]) {
                        checked[i][j]=true;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=1;j<=n;j++) {
                if(checked[i][j] || checked[j][i]) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}
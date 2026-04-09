import java.lang.Math;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int prevIndex = -1;
        for(int i=1;i<land.length;i++) {
            
            for(int j=0;j<land[i].length;j++) {
                int maxNum = 0;
                for(int k=0;k<land[i-1].length;k++) {
                    if(j==k) {
                        continue;
                    }
                    maxNum = Math.max(maxNum, land[i-1][k]);
                }
                land[i][j] += maxNum;
            }
            
        }
        for(int i=0;i<4;i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
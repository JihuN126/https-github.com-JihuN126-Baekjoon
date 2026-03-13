import java.lang.Math;
class Solution {
    public int solution(int[][] sizes) {
        int Max1 = 0, Max2 = 0;
        int width, height;
        for(int i=0;i<sizes.length;i++) {
            for(int j=0;j<sizes[i].length;j++) {
                if(Max1<sizes[i][j]) {
                    Max1 = sizes[i][j];
                    width = i;
                    height = j;
                }
            } 
        }
        for(int i=0;i<sizes.length;i++) {
            if(Max2 < Math.min(sizes[i][0], sizes[i][1])) {
                Max2 = Math.min(sizes[i][0], sizes[i][1]);
            }
        }
        return Max1 * Max2;
    }
}
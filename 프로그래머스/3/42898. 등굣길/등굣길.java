class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] Arr = new int[n][m];
        
        for(int[] p : puddles) {
            Arr[p[1]-1][p[0]-1] = -1;
        }

        Arr[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(Arr[i][j] == -1) {
                    Arr[i][j] = 0; 
                    continue;
                }
                
                if(i > 0) {
                    Arr[i][j] = (Arr[i][j] + Arr[i-1][j]) % 1000000007;
                }
                if(j > 0) {
                    Arr[i][j] = (Arr[i][j] + Arr[i][j-1]) % 1000000007;
                }
            }
        }
        
        return Arr[n-1][m-1];
    }
}
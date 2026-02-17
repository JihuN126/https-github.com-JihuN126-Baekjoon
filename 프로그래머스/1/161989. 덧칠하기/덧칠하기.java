class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintArea = 0;
        for(int i=0;i<section.length;i++) {
            int N = section[i];
            
            if(N>paintArea) {
                answer++;
                paintArea = N + m - 1;
            }
        }
        return answer;    
    }
}
import java.lang.Math;
class Solution {
    int max = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // int answer = -1;
        int count=1;
        visited = new boolean[dungeons.length];
        int answer = DFS(k, dungeons, count);
        return answer;
    }
    
    public int DFS(int k, int[][] dungeongs, int count) {
        
        for(int i=0;i<dungeongs.length;i++) {
            if(!visited[i] && k>=dungeongs[i][0] && k-dungeongs[i][1]>=0) {
                // System.out.println(i + " " + (k-dungeongs[i][1]) + " " + count);
                visited[i] = true;
                // System.out.println("max : " + max);
                max = Math.max(max, count);
                // System.out.println("max : " + max);
                DFS(k-dungeongs[i][1], dungeongs, count+1);
                visited[i] = false;
            }
        }
        return max;
    }
}
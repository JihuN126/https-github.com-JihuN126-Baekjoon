import java.util.*;
class Solution {
    public boolean visited[];
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        visited = new boolean[n+1];
        int count = 0;
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) continue;
                if(computers[i][j]==1) {
                    list[i+1].add(j+1);
                }
            }
        }
        for(int i=1;i<=n;i++) {
            if(!visited[i]) {
                count++;
                BFS(i, list);
            }
        }
        
        return count;
    }
    public void BFS(int start, ArrayList<Integer>[] list) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()) {
            int now = que.poll();
            for(int i : list[now]) {
                if(!visited[i]){
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
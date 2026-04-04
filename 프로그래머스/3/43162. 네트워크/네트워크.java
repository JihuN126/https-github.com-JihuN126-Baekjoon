import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<computers.length;i++) {
            for(int j=0;j<computers[i].length;j++) {
                if(i==j) continue;
                if(computers[i][j]==1) {
                    graph[i+1].add(j+1);
                }
            }
        }
        for(int i=1;i<=n;i++) {
            if(!visited[i]) {
                DFS(i);
                answer++;
            }
        }
        return answer;
    }
    public void DFS(int start) {
        visited[start] = true;
        for(int next : graph[start]) {
            if(!visited[next]) {
                DFS(next);
                visited[next] = true;
            }
        }
        return;
    }
}
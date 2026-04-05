import java.util.*;
import java.lang.Math;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            graph[start].add(end);
            graph[end].add(start);
        }
        BFS(1);
        int result=0;
        for(int i=1;i<=n;i++) {
            result = Math.max(result, dist[i]);
        }
        for(int i=1;i<=n;i++) {
            if(result==dist[i]) answer++;
        }
        return answer;
    }
    public void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int next : graph[cur]) {
                if(!visited[next]) {
                    dist[next] = dist[cur] + 1;
                    que.add(next);
                    visited[next]=true;
                }
            }
        }
    }
}
import java.util.*;
import java.lang.Math;
class Solution {
    class Node{
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    ArrayList<Node>[] graph;
    boolean[] visited;
    int[][] dist;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[3][n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
            dist[0][i] = Integer.MAX_VALUE;
            dist[1][i] = Integer.MAX_VALUE;
            dist[2][i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<fares.length;i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        Dijkstra(s,0);
        Dijkstra(a,1);
        Dijkstra(b,2);
        for(int i=1;i<=n;i++) {
            int distSum = dist[0][i] + dist[1][i] + dist[2][i];
            answer = Math.min(answer, distSum);
        }
        return answer;
    }
    public void Dijkstra(int start, int index) {
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        que.add(new Node(start,0));
        dist[index][start]=0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int end = cur.end; 
            int cost = cur.cost;
            if(dist[index][end] < cost) continue; 
            for(Node next : graph[end]) {
                if(dist[index][next.end] > cost + next.cost) {
                    dist[index][next.end] = cost + next.cost;
                    que.add(new Node(next.end, dist[index][next.end]));
                }
            }
        }
    }
}
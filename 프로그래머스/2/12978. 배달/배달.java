import java.util.*;


class Solution {
    class Node implements Comparable<Node>{
        int destination, time;
        public Node(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    int[] dist;
    ArrayList<Node>[] list;
    static final int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for(int i=0;i<road.length;i++) {
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];
            list[start].add(new Node(end, time));
            list[end].add(new Node(start, time));
        }
        Dijkstra(1);
        for(int i=1;i<=N;i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
    public void Dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        dist[start] = 0;
        que.add(new Node(start,0));
        while(!que.isEmpty()) {
            Node node = que.poll();
            int destination = node.destination;
            int time = node.time;
            
            if(dist[destination] < time) continue;
            for(Node next : list[destination]) {
                if(dist[next.destination] > dist[destination] + next.time) {
                    dist[next.destination] = dist[destination] + next.time;
                    que.add(new Node(next.destination, dist[next.destination]));
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    static ArrayList<Node>[] graph;
    static class Node {
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int Start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1;i<=V;i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }
        Dijkstra(Start);
        for(int i=1;i<=V;i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
    public static void Dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>(((o1, o2) -> o1.weight-o2.weight));
        que.add(new Node(start,0));
        dist[start]=0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int end = cur.end;
            int weight = cur.weight;
            for(Node temp : graph[end]) {
                if(dist[temp.end] > weight + temp.weight) {
                    dist[temp.end] = weight + temp.weight;
                    que.add(new Node(temp.end, dist[temp.end]));
                }
            }
        }
    }
}

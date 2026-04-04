import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int V,E,P;
    static ArrayList<Node>[] graph;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        dist = new int[3][V+1];

        for(int i=1;i<=V;i++) {
            graph[i] = new ArrayList<>();
            dist[0][i] = Integer.MAX_VALUE;
            dist[1][i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        }
        Dijkstra(1,0);
        Dijkstra(P,1);
        if(dist[0][V] == dist[0][P] + dist[1][V]) {
            System.out.println("SAVE HIM");
        }
        else {
            System.out.println("GOOD BYE");
        }

    }
    public static void Dijkstra(int start, int index) {
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->o1.weight - o2.weight);
        que.add(new Node(start,0));
        dist[index][start] = 0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int end = cur.end;
            int weight = cur.weight;
            if(dist[index][end] < weight) continue;
            for(Node next : graph[end]) {
                if(dist[index][next.end] >= weight + next.weight) {
                    dist[index][next.end] = weight + next.weight;
                    que.add(new Node(next.end, dist[index][next.end]));
                }
            }
        }
    }
}
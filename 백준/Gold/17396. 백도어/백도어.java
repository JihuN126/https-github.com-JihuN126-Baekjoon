import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int end;
        long weight;
        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] graph;
    static boolean[] checked;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        dist = new long[N];
        checked = new boolean[N];
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int ward = Integer.parseInt(st.nextToken());
            if(ward==0 || i==N-1) {
                checked[i] = false;
            }
            else {
                checked[i] = true;
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(checked[start] || checked[end]) continue;
            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start,weight));
        }
        Dijkstra(0);
        System.out.println(dist[N-1]==Long.MAX_VALUE ? -1 : dist[N-1]);
    }
    public static void Dijkstra(int start) {
        
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
        que.add(new Node(start,0));
        dist[start]=0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int end = cur.end;
            long weight = cur.weight;

            if (dist[end] < weight) continue;

            for(Node temp : graph[end]) {
                if(dist[temp.end] > weight + temp.weight) {
                    dist[temp.end] = weight + temp.weight;
                    que.add(new Node(temp.end, dist[temp.end]));
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int V;
        int Cost;
        public Node(int V, int Cost) {
            this.V = V;
            this.Cost = Cost;
        }
    }
    static ArrayList<Node>[] Graph;
    static int[] Dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        Graph = new ArrayList[V + 1];
        Dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            Graph[i] = new ArrayList<>();
            Dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int UofV = Integer.parseInt(st.nextToken());
            int VofV = Integer.parseInt(st.nextToken());
            int WofV = Integer.parseInt(st.nextToken());
            Graph[UofV].add(new Node(VofV, WofV));
        }
        Dijkstra(K);
        for (int i = 1; i <= V; i++) System.out.println(Dist[i] == Integer.MAX_VALUE ? "INF" : Dist[i]);
    }
    static void Dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.Cost - o2.Cost);
        q.add(new Node(start, 0));
        Dist[start] = 0;
        while (!q.isEmpty()) {
            Node Now = q.poll();
            for(int i=0;i<Graph[Now.V].size();i++){
                Node Next = Graph[Now.V].get(i);
                if(Dist[Next.V] > Now.Cost + Next.Cost){
                    Dist[Next.V] = Now.Cost + Next.Cost;
                    q.add(new Node(Next.V, Dist[Next.V]));
                }
            }
        }
    }
}
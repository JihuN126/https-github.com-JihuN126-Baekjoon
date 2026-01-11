import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 200000000;
    static class Node{
        int V;
        int Cost;
        public Node(int V, int Cost) {
            this.V = V;
            this.Cost = Cost;
        }
    }
    static ArrayList<Node>[] Graph;
    static int N,E;
    static int[] Dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N + 1];
        Dist = new int[N + 1];
        for (int i = 1; i <= N; i++)  Graph[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int Start = Integer.parseInt(st.nextToken());
            int End = Integer.parseInt(st.nextToken());
            int Cost = Integer.parseInt(st.nextToken());
            Graph[Start].add(new Node(End, Cost));
            Graph[End].add(new Node(Start, Cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int root1 = Dijkstra(1,v1)+Dijkstra(v1,v2)+Dijkstra(v2,N);
        int root2 = Dijkstra(1,v2)+Dijkstra(v2,v1)+Dijkstra(v1,N);
        System.out.println((root1>=INF && root2>=INF)?-1:Math.min(root1,root2));
    }
    static int Dijkstra(int start,int end) {
        Arrays.fill(Dist,INF);
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.Cost - o2.Cost);
        q.add(new Node(start, 0));
        Dist[start] = 0;
        while (!q.isEmpty()) {
            Node Now = q.poll();
            if(Now.Cost>Dist[Now.V]) continue;
            for(int i=0;i<Graph[Now.V].size();i++){
                Node Next = Graph[Now.V].get(i);
                if(Dist[Next.V] > Now.Cost + Next.Cost){
                    Dist[Next.V] = Now.Cost + Next.Cost;
                    q.add(new Node(Next.V, Dist[Next.V]));
                }
            }
        }
        return Dist[end];
    }
}
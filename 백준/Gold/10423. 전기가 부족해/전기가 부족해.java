import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static class Node implements Comparable<Node>{
        int Destination, Cost;
        public Node(int destination, int cost) {
            Destination = destination;
            Cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.Cost - o.Cost;
        }
    }
    static ArrayList<Node>[] Cable;
    static int[] PowerPlant;
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Cable = new ArrayList[N+1];
        Visited = new boolean[N+1];
        PowerPlant = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) PowerPlant[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) Cable[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Cable[u].add(new Node(v,w));
            Cable[v].add(new Node(u,w));
        }
        System.out.println(Prim(PowerPlant));
    }
    public static int Prim(int[] Arr) {
        int Sum=0;
        PriorityQueue<Node> Que = new PriorityQueue<>();
        for(int i=0;i<Arr.length;i++) Que.add(new Node(Arr[i], 0));
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(Visited[temp.Destination]) continue;
            Sum+=temp.Cost;
            Visited[temp.Destination] = true;
            for(Node next : Cable[temp.Destination]) {
                if(!Visited[next.Destination]) {
                    Que.add(next);
                }
            }
        }
        return Sum;
    }
}

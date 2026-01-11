import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,A,B,C,MaxCost=0,CostSum=0;
    private static class Edge implements Comparable<Edge> {
        int Destination, Cost;
        public Edge(int destination, int cost) {
            Destination = destination;
            Cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.Cost - o.Cost;
        }
    }
    static ArrayList<Edge>[] VertexList;
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        VertexList = new ArrayList[N+1];
        Visited = new boolean[N+1];
        for(int i=1;i<=N;i++) VertexList[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            VertexList[A].add(new Edge(B,C));
            VertexList[B].add(new Edge(A,C));
        }
        Prim(1);
        System.out.println(CostSum - MaxCost);
    }
    public static void Prim(int Start){
        PriorityQueue<Edge> Que = new PriorityQueue<>();
        Que.add(new Edge(Start,0));
        while(!Que.isEmpty()) {
            Edge edge = Que.poll();
            if(Visited[edge.Destination]) continue;
            CostSum += edge.Cost;
            MaxCost = Math.max(MaxCost, edge.Cost);
            Visited[edge.Destination] = true;
            for(Edge temp : VertexList[edge.Destination]) {
                if(!Visited[temp.Destination]) {
                    Que.add(temp);
                }
            }
        }
    }
}
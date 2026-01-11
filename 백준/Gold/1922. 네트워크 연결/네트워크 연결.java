import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int End, Cost;
    public Edge(int end,int cost) {
        End = end;
        Cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.Cost - o.Cost;
    }
}
public class Main {
    static int N,M,a,b,c,Sum=0;
    static ArrayList<Edge>[] VertexList;
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        VertexList = new ArrayList[N+1];
        Visited = new boolean[N+1];
        for(int i=1;i<=N;i++) VertexList[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            VertexList[a].add(new Edge(b,c));
            VertexList[b].add(new Edge(a,c));
        }
        Prim(1);
        System.out.println(Sum);
    }
    public static void Prim(int K){
        Queue<Edge> Que = new PriorityQueue<>();
        Que.add(new Edge(K,0));
        while(!Que.isEmpty()){
            Edge edge = Que.poll();
            if(Visited[edge.End]) continue;
            Sum += edge.Cost;
            Visited[edge.End] = true;
            for(Edge temp : VertexList[edge.End]){
                if(!Visited[temp.End]){
                    Que.add(temp);
                }
            }
        }
    }
}


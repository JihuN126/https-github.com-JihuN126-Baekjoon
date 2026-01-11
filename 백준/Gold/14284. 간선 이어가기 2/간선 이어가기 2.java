import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static class Node{
        int Destination, Cost;
        public Node(int destination, int cost) {
            Destination = destination;
            Cost = cost;
        }
    }
    static ArrayList<Node>[] Graph;
    static int[] MinDist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[n+1];
        MinDist = new int[n+1];
        Arrays.fill(MinDist,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++) Graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Graph[a].add(new Node(b,c));
            Graph[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        Dijkstra(Integer.parseInt(st.nextToken()));
        System.out.println(MinDist[Integer.parseInt(st.nextToken())]);
    }
    public static void Dijkstra(int Start) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Cost - o2.Cost));
        Que.add(new Node(Start, 0));
        MinDist[Start] = 0;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(MinDist[temp.Destination] < temp.Cost) continue;
            for(Node next : Graph[temp.Destination]) {
                if(MinDist[next.Destination] > temp.Cost + next.Cost) {
                    MinDist[next.Destination] = temp.Cost + next.Cost;
                    Que.add(new Node(next.Destination, MinDist[next.Destination]));
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static class Node{
        int Destination, Time;
        public Node(int destination, int time) {
            Destination = destination;
            Time = time;
        }
    }
    static ArrayList<Node>[] Graph;
    static int[][] Arr;
    static int[] Time;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[n+1];
        Arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++) Graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Graph[start].add(new Node(end, time));
            Graph[end].add(new Node(start, time));
        }
        for(int i=1;i<=n;i++) Dijkstra(i);
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j) sb.append("- ");
                else sb.append(Arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void Dijkstra(int start) {
        Time = new int[n+1];
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Time - o2.Time));
        Arrays.fill(Time,Integer.MAX_VALUE);
        Time[start] = 0;
        Que.add(new Node(start,0));
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(Time[temp.Destination] < temp.Time) continue;
            for(int i=0;i<Graph[temp.Destination].size();i++) {
                Node next = Graph[temp.Destination].get(i);
                if(Time[next.Destination] > temp.Time + next.Time) {
                    Time[next.Destination] = temp.Time + next.Time;
                    Arr[next.Destination][start] = temp.Destination;
                    Que.add(new Node(next.Destination, Time[next.Destination]));
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,X,MaxTime=0;
    static class Node {
        int Destination, Time;
        public Node(int destination, int time) {
            Destination = destination;
            Time = time;
        }
    }
    static ArrayList<Node>[] Graph;
    static int[] Time, XTime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N+1];
        Time = new int[N+1];
        XTime = new int[N+1];
        Arrays.fill(Time, Integer.MAX_VALUE);
        for(int i=1;i<=N;i++) {
            Graph[i] = new ArrayList<>();
        }
        for(int i=1;i<M+1;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Graph[start].add(new Node(end, time));
        }
        Dijkstra(X);
        for(int i=0;i<=N;i++) XTime[i] = Time[i];
        for(int i=1;i<=N;i++) {
            Arrays.fill(Time, Integer.MAX_VALUE);
            Dijkstra(i);
            MaxTime = MaxTime < Time[X] + XTime[i] ? Time[X] + XTime[i] : MaxTime;
        }
        System.out.println(MaxTime);
    }
    public static void Dijkstra(int Start) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Time - o2.Time));
        Que.add(new Node(Start,0));
        Time[Start] = 0;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            for(int i=0;i<Graph[temp.Destination].size();i++) {
                Node next = Graph[temp.Destination].get(i);
                if(Time[next.Destination] > temp.Time + next.Time) {
                    Time[next.Destination] = temp.Time + next.Time;
                    Que.add(new Node(next.Destination, Time[next.Destination]));
                }
            }
        }
    }
}

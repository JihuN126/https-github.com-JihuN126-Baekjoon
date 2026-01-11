import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static class Node{
        int Destination, Cow;
        public Node(int destination, int cow) {
            Destination = destination;
            Cow = cow;
        }
    }
    static int[] Arr;
    static ArrayList<Node>[] Graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N+1];
        Arr = new int[N+1];
        for(int i=1;i<=N;i++) Graph[i] = new ArrayList<>();
        Arrays.fill(Arr, Integer.MAX_VALUE);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Graph[A].add(new Node(B,C));
            Graph[B].add(new Node(A,C));
        }
        Dijkstra(1);
        System.out.println(Arr[N]);
    }
    public static void Dijkstra(int Start) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Cow - o2.Cow));
        Que.add(new Node(Start,0));
        Arr[Start] = 0;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(Arr[temp.Destination] < temp.Cow) continue;
            for(int i=0;i<Graph[temp.Destination].size();i++) {
                Node next = Graph[temp.Destination].get(i);
                if(Arr[next.Destination] > temp.Cow + next.Cow) {
                    Arr[next.Destination] = temp.Cow + next.Cow;
                    Que.add(new Node(next.Destination, Arr[next.Destination]));
                }
            }
        }
    }
}

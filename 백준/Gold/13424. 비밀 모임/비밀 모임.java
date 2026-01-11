import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T,N,M,FriendCount, Min = Integer.MAX_VALUE, index;
    static class Node{
        int Destination, Dist;
        public Node(int destination, int dist) {
            Destination = destination;
            Dist = dist;
        }
    }
    static ArrayList<Node>[] Graph;
    static int[] Friend, Result;
    static int[][] MinDist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Graph = new ArrayList[N+1];
            Result = new int[N+1];
            for(int j=1;j<=N;j++) Graph[j] = new ArrayList<>();
            for(int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Graph[a].add(new Node(b,c));
                Graph[b].add(new Node(a,c));
            }
            FriendCount = Integer.parseInt(br.readLine());
            Friend = new int[FriendCount];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<FriendCount;j++) Friend[j] = Integer.parseInt(st.nextToken());
            MinDist = new int[FriendCount][N+1];
            for(int j=0;j<FriendCount;j++) Arrays.fill(MinDist[j], Integer.MAX_VALUE);
            for(int j=0;j<FriendCount;j++) {
                Dijkstra(Friend[j],j);
            }
            for(int j=1;j<=N;j++) {
                int Sum = 0;
                for(int k=0;k<FriendCount;k++) {
                    Sum += MinDist[k][j];
                }
                if(Min > Sum) {
                    Min = Sum;
                    index = j;
                }
            }
            sb.append(index + "\n");
            Min = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }
    public static void Dijkstra(int Start,int index) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Dist-o2.Dist));
        Que.add(new Node(Start,0));
        MinDist[index][Start] = 0;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(MinDist[index][temp.Destination] < temp.Dist) continue;
            for(Node next : Graph[temp.Destination]) {
                if(MinDist[index][next.Destination] > temp.Dist + next.Dist){
                    MinDist[index][next.Destination] = temp.Dist + next.Dist;
                    Que.add(new Node(next.Destination, MinDist[index][next.Destination]));
                }
            }
        }
    }
}

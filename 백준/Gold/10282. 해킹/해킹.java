import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T,n,d,c,a,b,s,Time,Count;
    static class Node{
        int Destination, Second;
        public Node(int destination, int second) {
            Destination = destination;
            Second = second;
        }
    }
    static ArrayList<Node>[] Computer;
    static int[] TimeList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            Count = 0;
            Time = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            Computer = new ArrayList[n+1];
            TimeList = new int[n+1];
            Arrays.fill(TimeList, Integer.MAX_VALUE);
            for(int j=0;j<=n;j++) Computer[j] = new ArrayList<>();
            for(int j=0;j<d;j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                Computer[b].add(new Node(a,s));
            }
            Dijkstra(c);
            for(int j=1;j<=n;j++) {
                if(TimeList[j] != Integer.MAX_VALUE) {
                    Count++;
                    Time = Math.max(Time, TimeList[j]);
                }
            }
            sb.append(Count + " " + Time + "\n");
        }
        System.out.println(sb);
    }
    public static void Dijkstra(int Start) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Second - o2.Second));
        Que.add(new Node(Start,0));
        TimeList[Start] = 0;
        while(!Que.isEmpty()) {
            Node now = Que.poll();
            if(TimeList[now.Destination] < now.Second) continue;
            for(int i=0;i<Computer[now.Destination].size();i++) {
                Node next = Computer[now.Destination].get(i);
                if(TimeList[next.Destination] > now.Second + next.Second) {
                    TimeList[next.Destination] = now.Second + next.Second;
                    Que.add(new Node(next.Destination, TimeList[next.Destination]));
                }
            }
        }
    }
}

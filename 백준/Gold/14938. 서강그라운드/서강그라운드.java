import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Root {
        int Destination;
        int Cost;

        public Root(int destination, int cost) {
            Destination = destination;
            Cost = cost;
        }
    }

    static ArrayList<Root>[] Graph;
    static int Dist[], Sum[], Item[];
    static int n,m,r;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        Item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) Item[i] = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[n+1];
        Dist = new int[n+1];
        Sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            Graph[i] = new ArrayList<>();
            Dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Graph[a].add(new Root(b, l));
            Graph[b].add(new Root(a, l));
        }
        int result=0;
        for (int i = 1; i <= n; i++) {
            Dijkstra(i);
            Arrays.fill(Dist,Integer.MAX_VALUE);
        }
        for(int i=1;i<=n;i++) result = Math.max(result, Sum[i]);
        System.out.println(result);
    }

    static void Dijkstra(int start) {
        PriorityQueue<Root> q = new PriorityQueue<>((o1, o2) -> o1.Cost - o2.Cost);
        q.add(new Root(start, 0));
        Dist[start] = 0;
        while (!q.isEmpty()) {
            Root temp = q.poll();
            if (temp.Cost > Dist[temp.Destination]) continue;
            for (Root next : Graph[temp.Destination]) {
                if (Dist[next.Destination] > temp.Cost + next.Cost) {
                    Dist[next.Destination] = temp.Cost + next.Cost;
                    q.add(new Root(next.Destination, Dist[next.Destination]));
                }
            }
        }
        for(int i=1;i<=n;i++)
            if(Dist[i]<=m)  Sum[start] += Item[i];
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] CostArr;
    static class Edge {
        int Destination, Cost;
        Edge(int destination, int cost) {
            this.Destination = destination;
            this.Cost = cost;
        }
    }
    static class Node implements Comparable<Node> {
        int Count, MinCost;
        long TotalCost;
        Node(int count, int mincost, long totalcost) {
            this.Count = count;
            this.MinCost = mincost;
            this.TotalCost = totalcost;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.TotalCost, o.TotalCost);
        }
    }
    static long[][] Arr;
    static ArrayList<Edge>[] Graph;
    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            CostArr = new int[N+1];
            Graph = new ArrayList[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1;i<=N;i++) {
                CostArr[i] = Integer.parseInt(st.nextToken());
                Graph[i] = new ArrayList<>();
            }
            for (int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                Graph[start].add(new Edge(end, cost));
                Graph[end].add(new Edge(start, cost));
            }
        System.out.println(Dijkstra());
    }

    public static long Dijkstra() {
        Arr = new long[N+1][2501];
        for (int i=0;i<=N;i++) Arrays.fill(Arr[i], Long.MAX_VALUE);
        PriorityQueue<Node> Que = new PriorityQueue<>();
        Que.offer(new Node(1, CostArr[1], 0));
        while (!Que.isEmpty()) {
            Node temp = Que.poll();
            if (temp.Count == N) return temp.TotalCost;
            for (Edge next : Graph[temp.Count]) {
                if (Arr[next.Destination][temp.MinCost] <= temp.TotalCost + (next.Cost * temp.MinCost)) continue;
                Arr[next.Destination][temp.MinCost] = temp.TotalCost + (next.Cost * temp.MinCost);
                Que.offer(new Node(next.Destination, Math.min(temp.MinCost, CostArr[next.Destination]), Arr[next.Destination][temp.MinCost]));
            }
        }
        return -1;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static class Road implements Comparable<Road> {
        int Destination;
        long Cost;
        int Count;

        Road (int destination, long cost, int count) {
            this.Destination = destination;
            this.Cost = cost;
            this.Count = count;
        }

        @Override
        public int compareTo(Road o) {
            return (int) (Cost - o.Cost);
        }
    }
    static ArrayList<Road>[] City;
    static long[][] MinTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        City = new ArrayList[N+1];
        for (int i=1;i<=N;i++) City[i] = new ArrayList<>();
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            City[start].add(new Road(end, cost, 0));
            City[end].add(new Road(start, cost, 0));
        }
        MinTime = new long[N+1][K+1];
        for (int i=0;i<=N;i++) {
            Arrays.fill(MinTime[i], Long.MAX_VALUE);
        }
        Dijkstra(1,0);
        long Result = Long.MAX_VALUE;
        for (int i=0;i<=K;i++) {
            Result = Math.min(MinTime[N][i], Result);
        }
        System.out.println(Result);
    }

    private static void Dijkstra(int y,int x) {
        PriorityQueue<Road> Que = new PriorityQueue<>();
        Que.offer(new Road(y, x, K));
        MinTime[y][x] = 0;
        while (!Que.isEmpty()) {
            Road temp = Que.poll();
            if (MinTime[temp.Destination][K-temp.Count] < temp.Cost) continue;
            for (Road next : City[temp.Destination]) {
                if (MinTime[next.Destination][K-temp.Count] > temp.Cost + next.Cost) {
                    MinTime[next.Destination][K-temp.Count] = temp.Cost + next.Cost;
                    Que.offer(new Road(next.Destination, MinTime[next.Destination][K - temp.Count], temp.Count));
                }
                if (temp.Count > 0 && MinTime[next.Destination][K-temp.Count+1] > temp.Cost) {
                    MinTime[next.Destination][K-temp.Count+1] = temp.Cost;
                    Que.offer(new Road(next.Destination, MinTime[next.Destination][K-temp.Count+1], temp.Count - 1));
                }
            }
        }
    }
}

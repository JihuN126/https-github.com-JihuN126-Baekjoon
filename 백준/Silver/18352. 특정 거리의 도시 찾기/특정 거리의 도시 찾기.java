import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 도로 정보
        int X = Integer.parseInt(st.nextToken()); // 시작 도시
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        Dijkstra(X);
        StringBuilder sb = new StringBuilder();
        boolean found = false; 
        for(int i=1; i<=N; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("-1");
        } else {
            System.out.print(sb);
        }
    }

    public static void Dijkstra(int start) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        dist[start] = 0;
        que.add(start);
        while (!que.isEmpty()) {
            int end = que.poll();
            for(int temp : graph[end]) {
                if(dist[temp] > dist[end] + 1) {
                    dist[temp] = dist[end] + 1;
                    que.add(temp);
                }
            }
        }
    }
}

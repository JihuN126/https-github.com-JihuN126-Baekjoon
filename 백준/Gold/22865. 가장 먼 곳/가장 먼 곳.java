import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int N,M;
    static ArrayList<Node>[] graph;
    static ArrayList<Integer> house = new ArrayList<>();
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++) {
            int houseNum = Integer.parseInt(st.nextToken());
            if(!house.contains(houseNum)) house.add(houseNum);
        }
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        dist = new int[house.size()][N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
            for(int j=0;j<house.size();j++) dist[j][i] =Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end,weight));
            graph[end].add(new Node(start,weight));
        }

        for(int i=0;i<house.size();i++) {
            Dijkstra(house.get(i), i);
        }
        int answerIndex = 0;
        int K = -1;
        for(int i=N;i>=0;i--) {
            int shortestPath = Integer.MAX_VALUE;
            for(int j=0;j<house.size();j++) {
                shortestPath = Math.min(shortestPath, dist[j][i]);
            }
            if(K < shortestPath) {
                K = shortestPath;
                answerIndex = i;
            }
        }
        System.out.println(answerIndex);
    }

    public static void Dijkstra(int start, int index) {
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
        que.add(new Node(start,0));
        dist[index][start]=0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int end = cur.end;
            int weight = cur.weight;
            if(dist[index][end] < weight) continue;
            for(Node next : graph[end]) {
                if(dist[index][next.end] > weight + next.weight) {
                    dist[index][next.end] = weight + next.weight;
                    que.add(new Node(next.end, dist[index][next.end]));
                }
            }
        }
    }
}
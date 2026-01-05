import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    static ArrayList<Node>[] list;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list[start].add(new Node(start,end,distance));
            list[end].add(new Node(end,start,distance));
        }
        for(int i=0;i<M;i++) {
            result = 0;
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            DFS(start,end,result);
            System.out.println(result);
        }
    }

    public static void DFS(int current, int target, int sum) {
        if (current == target) {
            result = sum;
            return;
        }
        visited[current] = true;
        for (Node next : list[current]) {
            if (!visited[next.end]) {
                DFS(next.end, target, sum + next.distance);
                if(result != 0) return;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        int root = 0;
        long cost = 0;
        long totalCost = 0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            totalCost += c;
            que.add(new int[]{a,b,c});
        }
        while(!que.isEmpty()) {
            if(root == N-1) break;
            int[] temp = que.poll();
            int a = temp[0];
            int b = temp[1];
            int c = temp[2];
            if(find(a)!=find(b)) {
                union(a,b);
                root++;
                cost += c;
            }
        }
        int parentNum = find(1);
        for(int i=1;i<=N;i++) {
            if(parentNum!=find(i)) {
                System.out.println(-1);
                return;
            }

        }
        System.out.println(totalCost-cost);
    }
    public static int find(int x) {
        if(x==parent[x]) return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB) {
            parent[rootB] = rootA;
        }
    }
}

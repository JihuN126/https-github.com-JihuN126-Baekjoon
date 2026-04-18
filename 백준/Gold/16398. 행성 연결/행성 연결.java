import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)-> o1[2]-o2[2]);
        parent = new int[N];
        for(int i=0;i<N;i++) {
            parent[i] = i;
        }
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int c = Integer.parseInt(st.nextToken());
                que.add(new int[]{i,j,c});
            }
        }
        int root = 0;
        long cost = 0;

        while(!que.isEmpty()) {
            if(root == N-1) break;
            int[] temp = que.poll();
            int a = temp[0];
            int b = temp[1];
            int c = temp[2];
            if(parent[find(a)]!=parent[find(b)]) {
                union(a,b);
                cost += c;
                root++;
            }
        }
        System.out.println(cost);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB) parent[rootA] = rootB;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int m, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            if (m == 0 && n == 0) break;

            PriorityQueue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
            parent = new int[m];

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            long totalWeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                que.add(new int[]{x, y, z});
                totalWeight += z;
            }

            int root = 0;
            long weight = 0;
            while (!que.isEmpty()) {
                int[] temp = que.poll();
                if (root == m - 1) break;

                if (find(temp[0]) != find(temp[1])) {
                    union(temp[0], temp[1]);
                    root++;
                    weight += temp[2];
                }
            }
            System.out.println(totalWeight - weight);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootB] = rootA;
    }
}
import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int bridges = 0;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : costs) {
            if (bridges == n - 1) break;

            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            if (find(start) != find(end)) {
                union(start, end);
                answer += cost;
                bridges++;
            }
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
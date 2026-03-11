import java.util.*;

class Solution {
    class Node {
        int y, x, time;
        public Node(int y, int x, int time) {
            this.y = y; this.x = x; this.time = time;
        }
    }
    public int[] dy = {-1, 0, 1, 0};
    public int[] dx = {0, -1, 0, 1};
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] start = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') { start[0] = i; start[1] = j; }
                if (maps[i].charAt(j) == 'L') { lever[0] = i; lever[1] = j; }
            }
        }

        int distToLever = bfs(maps, start[0], start[1], 'L');
        if (distToLever == -1) return -1;

        int distToExit = bfs(maps, lever[0], lever[1], 'E');
        if (distToExit == -1) return -1;

        return distToLever + distToExit;
    }

    public int bfs(String[] maps, int startY, int startX, char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(startY, startX, 0));
        visited[startY][startX] = true;
        while (!que.isEmpty()) {
            Node tmp = que.poll();

            if (maps[tmp.y].charAt(tmp.x) == target) {
                return tmp.time;
            }

            for (int i = 0; i < 4; i++) {
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m && 
                    maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                    
                    visited[ny][nx] = true;
                    que.add(new Node(ny, nx, tmp.time + 1));
                }
            }
        }
        return -1;
    }
}
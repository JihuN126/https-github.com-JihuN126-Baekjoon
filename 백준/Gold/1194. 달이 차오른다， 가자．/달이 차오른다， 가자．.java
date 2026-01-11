import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
    public static char[][] Map;
    public static boolean[][][] Visited;
    static class Node {
        int y;
        int x;
        int Count;
        int Key;

        public Node(int y, int x, int Count, int Key) {
            this.y = y;
            this.x = x;
            this.Count = Count;
            this.Key = Key;
        }

    }
    public static Node start;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new char[N][M];
        Visited = new boolean[64][N][M];
        for (int i = 0; i < N; i++) {
            String Str = br.readLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = Str.charAt(j);
                if (Map[i][j] == '0')
                    start = new Node(i, j, 0, 0);
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Node> Que = new LinkedList<>();
        Que.offer(new Node(start.y, start.x, 0, 0));
        Visited[0][start.y][start.x] = true;
        while (!Que.isEmpty()) {
            Node node = Que.poll();
            if (Map[node.y][node.x] == '1') return node.Count;
            for (int i=0;i<4;i++) {
                int Dy = node.y + dy[i];
                int Dx = node.x + dx[i];
                if(Dy < 0 || Dx < 0 || Dy >= N || Dx >= M) continue;
                if(Map[Dy][Dx] != '#' && !Visited[node.Key][Dy][Dx]) {
                    if (Map[Dy][Dx] == '.' || Map[Dy][Dx] == '0' || Map[Dy][Dx] == '1') {
                        Visited[node.Key][Dy][Dx] = true;
                        Que.offer(new Node(Dy, Dx, node.Count + 1, node.Key));
                    }
                    else if (Map[Dy][Dx] >= 'a' && Map[Dy][Dx] <= 'z') {
                        int newKey = 1 << (Map[Dy][Dx] - 'a');
                        newKey = newKey | node.Key;
                        if (!Visited[newKey][Dy][Dx]) {
                            Visited[node.Key][Dy][Dx] = true;
                            Visited[newKey][Dy][Dx] = true;
                            Que.offer(new Node(Dy, Dx, node.Count + 1, newKey));
                        }
                    }
                    else if (Map[Dy][Dx] >= 'A' && Map[Dy][Dx] <= 'Z') {
                        int door = 1 << (Map[Dy][Dx] - 'A');
                        if ((node.Key & door) > 0) {
                            Visited[node.Key][Dy][Dx] = true;
                            Que.offer(new Node(Dy, Dx, node.Count + 1, node.Key));
                        }
                    }
                }
            }
        }
        return -1;
    }
}


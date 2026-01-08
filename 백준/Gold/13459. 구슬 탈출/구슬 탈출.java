import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static char[][] board;
    public static int N,M;
    public static int[] dx = {-1, 1, 0, 0},dy = {0, 0, -1, 1};
    public static class Marble {
        int x, y;
        public Marble(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Marble red = null, blue = null;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'B') blue = new Marble(i, j);
                else if (c == 'R') red = new Marble(i, j);
                board[i][j] = c;
            }
        }
        Queue<Marble[]> Que = new LinkedList<>();
        Que.add(new Marble[]{red, blue});
        boolean[][][][] visit = new boolean[N][M][N][M];
        visit[red.x][red.y][blue.x][blue.y] = true;
        int cnt = 0;
        while (!Que.isEmpty() && cnt++ < 10) {
            int size = Que.size();
            for (int i = 0; i < size; i++) {
                Marble[] cur = Que.poll();
                for (int k = 0; k < 4; k++) {
                    Marble r = new Marble(cur[0].x, cur[0].y);
                    Marble b = new Marble(cur[1].x, cur[1].y);
                    boolean redFirst = isRedFirst(r, b, k);
                    move(r, k);
                    move(b, k);
                    if (board[b.x][b.y] == 'O') continue;
                    if (r.x == b.x && r.y == b.y) {
                        setOrder(r, b, k, redFirst);
                    }
                    if (board[r.x][r.y] == 'O') {
                        System.out.println(1);
                        return;
                    }
                    if (visit[r.x][r.y][b.x][b.y]) continue;
                    visit[r.x][r.y][b.x][b.y] = true;
                    Que.add(new Marble[]{r, b});
                }
            }
        }
        System.out.println(0);
    }
    public static boolean isRedFirst(Marble r, Marble b, int d) {
        if ((d == 0 && r.x < b.x) ||
                (d == 1 && r.x > b.x) ||
                (d == 2 && r.y < b.y) ||
                (d == 3 && r.y > b.y)) return true;
        else return false;
    }
    public static void setOrder(Marble r, Marble b, int d, boolean redFirst) {
        switch (d) {
            case 0:
                if (redFirst) b.x++;
                else r.x++;
                break;
            case 1:
                if (redFirst) b.x--;
                else r.x--;
                break;
            case 2:
                if (redFirst) b.y++;
                else r.y++;
                break;
            case 3:
                if (redFirst) b.y--;
                else r.y--;
                break;
        }
    }
    public static void move(Marble m, int d) {
        while (true) {
            int nx = m.x + dx[d];
            int ny = m.y + dy[d];
            if (board[nx][ny] == '#') break;
            m.x = nx;
            m.y = ny;
            if (board[nx][ny] == 'O') break;
        }
    }
}
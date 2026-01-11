import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] Arr;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int Cheese=0, Cnt=0, Before=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
                if (Arr[i][j] == 1) Cheese++;
            }
        }

        Queue<Integer> Que = new LinkedList<>();
        while (Cheese > 0) {
            int[][] Visit = new int[N][M];
            Que.add(0);
            Que.add(0);
            Visit[0][0] = 1;
            Before = Cheese;
            Cnt++;
            while (!Que.isEmpty()) {
                int y = Que.poll();
                int x = Que.poll();
                for (int i=0; i<4; i++) {
                    int Y = y + dy[i];
                    int X = x + dx[i];
                    if (0 <= Y && Y < N && 0 <= X && X < M && Visit[Y][X] == 0) {
                        Visit[Y][X] = 1;
                        if (Arr[Y][X] == 0) {
                            Que.add(Y);
                            Que.add(X);
                        }
                        else {
                            Arr[Y][X] = 0;
                            Cheese--;
                        }
                    }
                }
            }
        }
        System.out.println(Cnt);
        System.out.println(Before);
    }
}

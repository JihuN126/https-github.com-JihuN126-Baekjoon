import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, Min = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int y,x,Cnt;
        public Node(int y, int x,int Cnt) {
            this.y = y;
            this.x = x;
            this.Cnt = Cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.Cnt - o.Cnt;
        }
    }
    static int[][] Miro;
    static boolean[][] Visited;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Miro = new int[N][M];
        Visited = new boolean[N][M];
        for(int i = 0; i< N; i++) {
            String str = br.readLine();
            for(int j = 0; j< M; j++) {
                Miro[i][j] = str.charAt(j) - '0';
            }
        }
        BFS(0,0);
        System.out.println(Min);
    }
    public static void BFS(int y,int x) {
        PriorityQueue<Node> Que = new PriorityQueue<>(((o1, o2) -> o1.Cnt - o2.Cnt));
        Que.add(new Node(y,x,0));
        Visited[y][x] = true;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(temp.y == N-1 && temp.x == M-1) {
                Min = Math.min(Min, temp.Cnt);
                return;
            }
            for(int i=0;i<4;i++) {
                int Dy = temp.y + dy[i];
                int Dx = temp.x + dx[i];
                if(Dy < 0 || Dx < 0 || Dy >= N || Dx >= M) continue;
                if(!Visited[Dy][Dx]){
                    if(Miro[Dy][Dx] == 0) Que.add(new Node(Dy,Dx,temp.Cnt));
                    else Que.add(new Node(Dy,Dx,temp.Cnt+1));
                    Visited[Dy][Dx] = true;
                }
            }
        }
    }
}

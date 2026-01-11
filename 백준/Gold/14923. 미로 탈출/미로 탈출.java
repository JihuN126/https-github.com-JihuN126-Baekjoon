import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,Hx,Hy,Ex,Ey,MinDist=Integer.MAX_VALUE;
    static int[][] Miro;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static boolean[][][] Visited;
    public static class Node{
        int y,x,Dist,Destroyed;
        public Node(int y, int x, int Dist, int Destroyed) {
            this.y = y;
            this.x = x;
            this.Dist = Dist;
            this.Destroyed = Destroyed;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Hy = Integer.parseInt(st.nextToken());
        Hx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Ey = Integer.parseInt(st.nextToken());
        Ex = Integer.parseInt(st.nextToken());
        Miro = new int[N][M];
        Visited = new boolean[2][N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) Miro[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(BFS(Hy-1,Hx-1));
    }
    public static int BFS(int Y, int X) {
        Queue<Node> Que = new LinkedList<>();
        Que.add(new Node(Y,X,1,0));
        Visited[0][Y][X] = true;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(temp.y==Ey-1 && temp.x==Ex-1) {
                MinDist = Math.min(temp.Dist,MinDist);
                return MinDist-1;
            }
            for(int i=0;i<4;i++) {
                int DX = temp.x + dx[i];
                int DY = temp.y + dy[i];
                if(DY<0 || DY>=N || DX<0 || DX>=M) continue;
                if(Miro[DY][DX] == 0 && !Visited[temp.Destroyed][DY][DX]){
                    Visited[temp.Destroyed][DY][DX] = true;
                    Que.add(new Node(DY,DX,temp.Dist+1, temp.Destroyed));
                }
                else if(Miro[DY][DX] == 1 && temp.Destroyed==0 && !Visited[temp.Destroyed+1][DY][DX]){
                    Visited[temp.Destroyed+1][DY][DX] = true;
                    Que.add(new Node(DY,DX,temp.Dist+1, temp.Destroyed+1));
                }
            }
        }
        return -1;
    }
}

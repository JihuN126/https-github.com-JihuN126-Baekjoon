import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K,MinDist=-1;
    static int[][] Map;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static boolean[][][] Visited;
    public static class Node implements Comparable<Node>{
        int y,x,Dist,Destroyed,Day;
        public Node(int y, int x, int Dist, int Destroyed,int Day) {
            this.y = y;
            this.x = x;
            this.Dist = Dist;
            this.Destroyed = Destroyed;
            this.Day = Day;
        }
        @Override
        public int compareTo(Node o) {
            if(this.Dist == o.Dist) return this.Destroyed - o.Destroyed;
            else return this.Dist - o.Dist;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        Visited = new boolean[K+1][N][M];
        for(int i=0;i<N;i++) {
            String S = br.readLine();
            for(int j=0;j<M;j++) Map[i][j] = S.charAt(j) - 48;
        }
        BFS();
        System.out.println(MinDist);
    }
    public static void BFS() {
        PriorityQueue<Node> Que = new PriorityQueue<>();
        Que.add(new Node(0,0,1,0,0));
        Visited[0][0][0] = true;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            if(temp.y==N-1 && temp.x==M-1) {
                MinDist = temp.Dist;
                return;
            }
            for(int i=0;i<4;i++) {
                int DX = temp.x + dx[i];
                int DY = temp.y + dy[i];
                if(DY<0 || DY>=N || DX<0 || DX>=M) continue;
                if(Map[DY][DX] == 0 && !Visited[temp.Destroyed][DY][DX]){
                    if(temp.Day == 0) Que.add(new Node(DY,DX,temp.Dist+1, temp.Destroyed,1));
                    else if(temp.Day == 1) Que.add(new Node(DY,DX,temp.Dist+1, temp.Destroyed,0));
                    Visited[temp.Destroyed][DY][DX] = true;
                }
                if(Map[DY][DX] == 1 && temp.Destroyed<=K-1 && !Visited[temp.Destroyed+1][DY][DX]){
                    if(temp.Day==0) Que.add(new Node(DY,DX,temp.Dist+1,temp.Destroyed+1,1));
                    else if(temp.Day==1) Que.add(new Node(DY,DX,temp.Dist+2, temp.Destroyed+1,1));
                    Visited[temp.Destroyed+1][DY][DX] = true;
                }
            }
        }
    }
}

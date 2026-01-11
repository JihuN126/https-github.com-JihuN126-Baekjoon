import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,MaxCount = 0;
    static int[][] Map, CopyMap;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        CopyMap = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Wall(0);
        System.out.println(MaxCount);
    }
    public static void Wall(int Count) {
        if(Count==3) {
            BFS();
            return;
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(Map[i][j]==0) {
                    Map[i][j] = 1;
                    Wall(Count+1);
                    Map[i][j] = 0;
                }
            }
        }
    }
    public static void BFS() {
        Queue<Node> Que = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++){
                CopyMap[i][j] = Map[i][j];
                if(CopyMap[i][j]==2) Que.add(new Node(i,j));
            }
        }
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            for(int i=0;i<4;i++) {
                int Dy = temp.y + dy[i];
                int Dx = temp.x + dx[i];
                if(Dy < 0 || Dx < 0 || Dy >= N || Dx >= M) continue;
                if(CopyMap[Dy][Dx]==0) {
                    CopyMap[Dy][Dx] = 2;
                    Que.add(new Node(Dy,Dx));
                }
            }
        }
        int SafeZoneCount = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(CopyMap[i][j]==0) SafeZoneCount++;
            }
        }
        MaxCount = Math.max(MaxCount, SafeZoneCount);
    }
}

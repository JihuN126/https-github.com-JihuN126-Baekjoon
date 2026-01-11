import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class NodeXYZ{
    int x, y, z;
    NodeXYZ(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int Day=1;
    static int[][][] Farm;
    static boolean[][][] Visit;
    static int[] MoveX = {-1,0,0,1,0,0};
    static int[] MoveY = {0,-1,0,0,1,0};
    static int[] MoveZ = {0,0,-1,0,0,1};
    static Queue<NodeXYZ> Tomato = new LinkedList<>();
    static int M, N, H;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Farm = new int[H][N][M];
        Visit = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    Farm[i][j][k] = Integer.parseInt(st.nextToken());
                    if (Farm[i][j][k] == 1) Tomato.offer(new NodeXYZ(i,j,k));
                }
            }
        }
        BFS();
        System.out.println(TomatoChecking());
    }
    public static void BFS(){
        while(!Tomato.isEmpty()){
            NodeXYZ Point = Tomato.poll();
            Visit[Point.z][Point.x][Point.y] = true;
            for(int i=0;i<6;i++){
                int Z1 = Point.z + MoveZ[i];
                int X1 = Point.x + MoveX[i];
                int Y1 = Point.y + MoveY[i];
                if(X1<0 || Y1<0 || Z1<0 || X1>=N || Y1>=M || Z1>=H) continue;
                if(Farm[Z1][X1][Y1] == 0 && !Visit[Z1][X1][Y1]){
                    Tomato.offer(new NodeXYZ(Z1,X1,Y1));
                    Visit[Z1][X1][Y1] = true;
                    Farm[Z1][X1][Y1] = Farm[Point.z][Point.x][Point.y] + 1;
                }
            }
        }
    }
    public static int TomatoChecking(){
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++) {
                        if (Farm[i][j][k] == 0) return -1;
                        else if (Farm[i][j][k] != -1 && Day < Farm[i][j][k]) Day = Farm[i][j][k];
                       }
                }
        }
        return Day-1;
    }
}
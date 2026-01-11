import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int Day=0;
    static int[][] Farm;
    static boolean[][] Visit;
    static int[] MoveX = {-1,0,1,0};
    static int[] MoveY = {0,-1,0,1};
    static Queue<Node> Tomato = new LinkedList<>();
    static int M, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Farm = new int[N][M];
        Visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                Farm[i][j] = Integer.parseInt(st.nextToken());
                if(Farm[i][j] == 1) Tomato.offer(new Node(i,j));
            }
        }
        BFS();
        System.out.println(TomatoChecking());
    }
    public static void BFS(){
        while(!Tomato.isEmpty()){
            Node Point = Tomato.poll();
            Visit[Point.x][Point.y] = true;
            for(int i=0;i<4;i++){
                int X1 = Point.x + MoveX[i];
                int Y1 = Point.y + MoveY[i];
                if(X1<0 || Y1<0 || X1>=N || Y1>=M) continue;
                if(Farm[X1][Y1] == 0 && !Visit[X1][Y1]){
                    Tomato.offer(new Node(X1,Y1));
                    Visit[X1][Y1] = true;
                    Farm[X1][Y1] = Farm[Point.x][Point.y] + 1;
                }
            }
        }
    }
    public static int TomatoChecking(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Farm[i][j] == 0) return -1;
                else if(Farm[i][j]!=-1 && Day<Farm[i][j]) Day = Farm[i][j];
            }
        }
        if(Day==1) return 0;
        return Day-1;
    }
}
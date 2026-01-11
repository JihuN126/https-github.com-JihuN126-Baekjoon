import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Root{
    int x, y;
    Root(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] Maze;
    static boolean[][] Visit;
    static int[] MoveX = {-1,0,1,0};
    static int[] MoveY = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Maze = new int[N][M];
        Visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++)  Maze[i][j] = (int)(str.charAt(j)) - 48;
        }
        BFS(0,0);
        System.out.println(Maze[N-1][M-1]);
    }
    public static void BFS(int x, int y){
        Queue<Root> Course = new LinkedList<>();
        Course.offer(new Root(x, y));
        Visit[x][y] = true;
        while(!Course.isEmpty()){
            Root Point = Course.poll();
            for(int i=0;i<4;i++){
                int x1 = Point.x + MoveX[i];
                int y1 = Point.y + MoveY[i];
                if(x1<0 || y1<0 || x1+1>N || y1+1>M) continue;
                if(!Visit[x1][y1] && Maze[x1][y1]==1){
                    Course.offer(new Root(x1, y1));
                    Visit[x1][y1] = true;
                    Maze[x1][y1] = Maze[Point.x][Point.y]+1;
                    if(x1==N-1 && y1==M-1)  return;
                }
            }
        }
    }
}
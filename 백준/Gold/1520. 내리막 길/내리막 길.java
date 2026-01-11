import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] Map, DP;
    static boolean[][] Visit;
    static int M,N;
    static int[] dy = {-1,0,1,0}, dx = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Map = new int[M][N];
        DP = new int[M][N];
        Visit = new boolean[M][N];
        for(int i=0;i<M;i++) Arrays.fill(DP[i], -1);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) Map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DFS(0,0));
    }
    public static int DFS(int y,int x){
        if(y==M-1 && x==N-1) return 1;
        if(DP[y][x]!=-1) return DP[y][x];
        DP[y][x]++;
        for(int i=0;i<4;i++){
            int Y = y + dy[i];
            int X = x + dx[i];
            if(Y<0 || X<0 || Y>=M || X>=N) continue;
            if(Map[y][x] > Map[Y][X]) DP[y][x] += DFS(Y,X);
        }
        return DP[y][x];
    }
}

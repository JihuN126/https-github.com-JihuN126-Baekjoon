import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] Dp;
    static int[] Left, Right;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Dp = new int[N+2][M+2];
        Left = new int[M+2];
        Right = new int[M+2];
        Left[0] = Left[M+1] = Integer.MIN_VALUE;
        Right[0] = Right[M+1] = Integer.MIN_VALUE;
        for(int i=0;i<N+2;i++) {
            for(int j=0;j<M+2;j++) Arrays.fill(Dp[i], Integer.MIN_VALUE);
        }

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) Dp[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=M;i++) {
            if(i==1) continue;
            Dp[1][i] += Dp[1][i-1];
        }
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                Left[j] = Dp[i][j] + Math.max(Dp[i-1][j], Left[j-1]);
                Right[M+1-j] = Dp[i][M+1-j] + Math.max(Dp[i-1][M+1-j], Right[M+2-j]);
            }
            for(int j=1;j<=M;j++) Dp[i][j] = Math.max(Left[j], Right[j]);
        }
        System.out.println(Dp[N][M]);
    }
}

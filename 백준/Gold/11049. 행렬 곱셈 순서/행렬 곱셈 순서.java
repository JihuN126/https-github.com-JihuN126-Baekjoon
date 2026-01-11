import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] Arr, Dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N][N];
        Dp = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Dp[i][0] = Integer.parseInt(st.nextToken());
            Dp[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int k=1; k<N; k++) {
            for(int i=0; i+k<N; i++) {
                Arr[i][i+k] = Integer.MAX_VALUE;
                for(int j=i; j<i+k; j++)
                    Arr[i][i+k] = Math.min(Arr[i][i+k], Arr[i][j]+Arr[j+1][i+k] + Dp[i][0]*Dp[j][1]*Dp[i+k][1]);
            }
        }
        System.out.println(Arr[0][N-1]);
    }
}

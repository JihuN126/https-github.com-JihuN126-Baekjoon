import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int T, W;
    private static int[] Arr;
    private static int[][][] Dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Arr = new int[T+1];
        for (int i=1;i<=T;i++) {
            Arr[i] = Integer.parseInt(br.readLine());
        }
        Dp = new int[3][T+1][W+2];
        for (int i=1;i<=T;i++) {
            for (int j=1;j<=W+1;j++) {
                if (Arr[i] == 1) {
                    Dp[1][i][j] = Math.max(Dp[1][i - 1][j], Dp[2][i - 1][j - 1]) + 1;
                    Dp[2][i][j] = Math.max(Dp[2][i - 1][j], Dp[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) continue;
                    Dp[1][i][j] = Math.max(Dp[1][i - 1][j], Dp[2][i - 1][j - 1]);
                    Dp[2][i][j] = Math.max(Dp[2][i - 1][j], Dp[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int Answer = 0;
        for (int i = 1; i <= W + 1; i++) {
            Answer = Math.max(Answer, Math.max(Dp[1][T][i], Dp[2][T][i]));
        }

        System.out.println(Answer);
    }
}

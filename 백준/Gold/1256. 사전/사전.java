import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K,INF = 1000000000;
    static long[][] Dp = new long[201][201];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= 200; i++){
            Dp[i][1] = i;
            Dp[i][0] = 1;
            Dp[i][i] = 1;
        }
        for(int i = 1 ; i <= 200; i++){
            for(int j = 1; j <= i; j++){
                Dp[i][j] = Dp[i-1][j] + Dp[i-1][j-1];
                if(Dp[i][j] > INF) Dp[i][j] = INF+1;
            }
        }
        if(Dp[N+M][M] < K){
            System.out.println("-1");
            return;
        }
        while(!(N==0&&M==0)){
            if(Dp[N+M-1][M] >= K){
                System.out.print("a");
                N--;
            } else {
                System.out.print("z");
                K -= Dp[N+M-1][M];
                M--;
            }
        }
    }
}
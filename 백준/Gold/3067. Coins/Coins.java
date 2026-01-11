import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T,N,M;
    static int[] Coin,Dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            Coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) Coin[j] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            Dp = new int[M];
            sb.append(DP() + "\n");
        }
        System.out.println(sb);
    }
    public static int DP() {
        for(int i=0;i<N;i++) {
            for(int j=1;j<=M;j++) {
                if((i==0 && j%Coin[i]==0) || j==Coin[i]) Dp[j-1]++;
                else if(Coin[i] < j) Dp[j-1] += Dp[j-1-Coin[i]];
            }
        }
        return Dp[M-1];
    }
}


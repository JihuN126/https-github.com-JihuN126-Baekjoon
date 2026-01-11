import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] Dp, Coin;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Dp = new int[k+1];
        Coin = new int[n];
        Arrays.fill(Dp, 100001);
        Dp[0] = 0;
        for(int i=0;i<n;i++) Coin[i] = Integer.parseInt(br.readLine());
        for(int i=1;i<=k;i++){
            for(int j=0;j<Coin.length;j++){
                if(Coin[j] <= i && Dp[i-Coin[j]] + 1 < Dp[i]) Dp[i] = Dp[i-Coin[j]]+1;
            }
        }
        System.out.println(Dp[k]>100000 ? -1 : Dp[k]);
    }
}

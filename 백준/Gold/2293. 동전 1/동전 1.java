import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] Dp,Coin;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Coin = new int[n];
        Dp = new int[k];
        for(int i=0;i<n;i++) Coin[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            for(int j=1;j<=k;j++){
                if(Coin[i] == j) Dp[j-1]++;
                else if(Coin[i] < j) Dp[j-1] += Dp[j-1-Coin[i]];
            }
        }
        System.out.println(Dp[k-1]);
    }
}

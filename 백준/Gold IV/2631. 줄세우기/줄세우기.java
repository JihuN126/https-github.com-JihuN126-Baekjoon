import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    static int N;
    static int[] Arr, Dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        Dp = new int[N];

        for (int i=0;i<N;i++) Arr[i] = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            Dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(Arr[j]<Arr[i]&&Dp[j]+1>Dp[i]) {
                    Dp[i]=Dp[j]+1;
                }
            }
        }
        Arrays.sort(Dp);
        System.out.println(N-Dp[N-1]);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][] Arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new long[1000001][2];
        System.out.println(Dp(N));
    }
    static long Dp(int n) {
        Arr[1][0]=2;
        Arr[2][0]=7;
        Arr[2][1]=1;
        for(int i=3;i<=n;i++) {
            Arr[i][1] = (Arr[i-1][1] + Arr[i-3][0]) % 1000000007;
            Arr[i][0] = (3 * Arr[i - 2][0] + 2 * Arr[i - 1][0] + 2 * Arr[i][1]) % 1000000007;
        }
        return Arr[n][0];
    }
}